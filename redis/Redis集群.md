安装Redis3.0
============

yum -y install cpp binutils glibc glibc-kernheaders glibc-common glibc-devel gcc
make gcc-c++ libstdc++-devel tcl

mkdir -p /usr/local/src/redis

cd /usr/local/src/redis

wget http://download.redis.io/releases/redis-3.0.2.tar.gz 或者 rz 上传

tar -xvf redis-3.0.2.tar.gz

cd redis-3.0.2

make

make test \#这个就不要执行了，需要很长时间

make install

cp redis.conf /etc/

vi /etc/redis.conf

\# 修改如下，默认为no

daemonize yes

\#启动

redis-server /etc/redis.conf

\#测试

redis-cli

主从复制（读写分离）
====================

主从复制的好处有2点：

1.  避免redis单点故障

2.  构建读写分离架构，满足读多写少的应用场景

主从架构
--------

![](media/aba36e0e3bda89450a0ac411d2a5756d.png)

### 启动实例

创建6379、6380、6381目录，分别将安装目录下的redis.conf拷贝到这三个目录下。

![](media/e1f0e77c5ac1ad4ed50a390cf9236067.png)

分别进入这三个目录，分别修改配置文件，将端口分别设置为：6379（Master）、6380（Slave）、6381（Slave）。同时要设置pidfile文件为不同的路径。

分别启动三个redis实例：

![](media/77fa32ae71ee6b85969d0ae24da25591.png)

### 设置主从

在redis中设置主从有2种方式：

1.  在redis.conf中设置slaveof

    1.  slaveof \<masterip\> \<masterport\>

2.  使用redis-cli客户端连接到redis服务，执行slaveof命令

    1.  slaveof \<masterip\> \<masterport\>

第二种方式在重启后将失去主从复制关系。

查看主从信息：INFO replication

主：

![](media/863d560db6fb2c3075797cda92562a80.png)

role：角色

connected_slaves：从库数量

slave0：从库信息

从：

![](media/ddb8cde2803e3e3442c9df5fc39210f4.png)

### 测试

在主库写入数据：

![](media/6a697a973b50383303c5874b900481ad.png)

在从库读取数据：

![](media/4cfe32455f330c33988c0a17dd5940ea.png)

主从从架构
----------

![](media/b0eafa363920a7f2a0b07c326697fd1d.png)

### 启动实例

![](media/971ab403ea7bc7fcc6f7102280c8dce5.png)

设置主从：

![](media/c9d6a0114cd8e7564acfba6e72b08a14.png)

设置从从：

![](media/492cd745c5bbec2356bdc602c2e49d01.png)

### 测试

在主库设置数据：

![](media/caaa7e7842818c36514b147f1c8512bd.png)

在6380获取数据：

![](media/ebe1780f0d37749066618f006e7ae328.png)

在6381获取数据：

![](media/646204a86776253736de7b9ca9b3bbb4.png)

从库只读
--------

默认情况下redis数据库充当slave角色时是只读的不能进行写操作。

![](media/ea33759034e3dabc7d314967a77dbd58.png)

可以在配置文件中开启非只读：slave-read-only no

复制的过程原理
--------------

1.  当从库和主库建立MS关系后，会向主数据库发送SYNC命令；

2.  主库接收到SYNC命令后会开始在后台保存快照（RDB持久化过程），并将期间接收到的写命令缓存起来；

3.  当快照完成后，主Redis会将快照文件和所有缓存的写命令发送给从Redis；

4.  从Redis接收到后，会载入快照文件并且执行收到的缓存的命令；

5.  之后，主Redis每当接收到写命令时就会将命令发送从Redis，从而保证数据的一致；

无磁盘复制
----------

通过前面的复制过程我们了解到，主库接收到SYNC的命令时会执行RDB过程，即使在配置文件中禁用RDB持久化也会生成，那么如果主库所在的服务器磁盘IO性能较差，那么这个复制过程就会出现瓶颈，庆幸的是，Redis在2.8.18版本开始实现了无磁盘复制功能（不过该功能还是处于试验阶段）。

原理：

Redis在与从数据库进行复制初始化时将不会将快照存储到磁盘，而是直接通过网络发送给从数据库，避免了IO性能差问题。

开启无磁盘复制：repl-diskless-sync yes

复制架构中出现宕机情况，怎么办？
--------------------------------

如果在主从复制架构中出现宕机的情况，需要分情况看：

1.  从Redis宕机

    1.  这个相对而言比较简单，在Redis中从库重新启动后会自动加入到主从架构中，自动完成同步数据；

    2.  问题？
        如果从库在断开期间，主库的变化不大，从库再次启动后，主库依然会将所有的数据做RDB操作吗？还是增量更新？（从库有做持久化的前提下）

        1.  不会的，因为在Redis2.8版本后就实现了，主从断线后恢复的情况下实现增量复制。

2.  主Redis宕机

    1.  这个相对而言就会复杂一些，需要以下2步才能完成

        1.  第一步，在从数据库中执行SLAVEOF NO
            ONE命令，断开主从关系并且提升为主库继续服务；

        2.  第二步，将主库重新启动后，执行SLAVEOF命令，将其设置为其他库的从库，这时数据就能更新回来；

    2.  这个手动完成恢复的过程其实是比较麻烦的并且容易出错，有没有好办法解决呢？当前有的，Redis提供的哨兵（sentinel）的功能。

哨兵（sentinel）
================

什么是哨兵
----------

顾名思义，哨兵的作用就是对Redis的系统的运行情况的监控，它是一个独立进程。它的功能有2个：

1.  监控主数据库和从数据库是否运行正常；

2.  主数据出现故障后自动将从数据库转化为主数据库；

原理
----

单个哨兵的架构：

![](media/e1b8a66ee0c27e7ff4733cd7b744190d.png)

多个哨兵的架构：

![](media/977e1c25004f9c58f30a2c766a8a4261.png)

多个哨兵，不仅同时监控主从数据库，而且哨兵之间互为监控。

环境
----

当前处于一主多从的环境中：

![](media/34089bbbc41076518d7e468e6f83b9a4.png)

配置哨兵
--------

启动哨兵进程首先需要创建哨兵配置文件：

vim sentinel.conf

输入内容：

sentinel monitor taotaoMaster 127.0.0.1 6379 1

说明：

taotaoMaster：监控主数据的名称，自定义即可，可以使用大小写字母和“.-_”符号

127.0.0.1：监控的主数据库的IP

6379：监控的主数据库的端口

1：最低通过票数

启动哨兵进程：

redis-sentinel ./sentinel.conf

![](media/e458b8726d7c50e22d76c65ba7d516b0.png)

由上图可以看到：

1.  哨兵已经启动，它的id为9059917216012421e8e89a4aa02f15b75346d2b7

2.  为master数据库添加了一个监控

3.  发现了2个slave（由此可以看出，哨兵无需配置slave，只需要指定master，哨兵会自动发现slave）

从数据库宕机
------------

![](media/76dc629f6ac3c8e90ffd6bd5ec24220c.png)

kill掉2826进程后，30秒后哨兵的控制台输出：

2989:X 05 Jun 20:09:33.509 \# +sdown slave 127.0.0.1:6380 127.0.0.1 6380 \@
taotaoMaster 127.0.0.1 6379

说明已经监控到slave宕机了，那么，如果我们将3380端口的redis实例启动后，会自动加入到主从复制吗？

2989:X 05 Jun 20:13:22.716 \* +reboot slave 127.0.0.1:6380 127.0.0.1 6380 \@
taotaoMaster 127.0.0.1 6379

2989:X 05 Jun 20:13:22.788 \# -sdown slave 127.0.0.1:6380 127.0.0.1 6380 \@
taotaoMaster 127.0.0.1 6379

可以看出，slave从新加入到了主从复制中。-sdown：说明是恢复服务。

![](media/7a52d52c56bbbbfd101281b732169f7c.png)

主库宕机
--------

哨兵控制台打印出如下信息：

2989:X 05 Jun 20:16:50.300 \# +sdown master taotaoMaster 127.0.0.1 6379
说明master服务已经宕机

2989:X 05 Jun 20:16:50.300 \# +odown master taotaoMaster 127.0.0.1 6379 \#quorum
1/1

2989:X 05 Jun 20:16:50.300 \# +new-epoch 1

2989:X 05 Jun 20:16:50.300 \# +try-failover master taotaoMaster 127.0.0.1 6379
开始恢复故障

2989:X 05 Jun 20:16:50.304 \# +vote-for-leader
9059917216012421e8e89a4aa02f15b75346d2b7 1
投票选举哨兵leader，现在就一个哨兵所以leader就自己

2989:X 05 Jun 20:16:50.304 \# +elected-leader master taotaoMaster 127.0.0.1 6379
选中leader

2989:X 05 Jun 20:16:50.304 \# +failover-state-select-slave master taotaoMaster
127.0.0.1 6379 选中其中的一个slave当做master

2989:X 05 Jun 20:16:50.357 \# +selected-slave slave 127.0.0.1:6381 127.0.0.1
6381 \@ taotaoMaster 127.0.0.1 6379 选中6381

2989:X 05 Jun 20:16:50.357 \* +failover-state-send-slaveof-noone slave
127.0.0.1:6381 127.0.0.1 6381 \@ taotaoMaster 127.0.0.1 6379 发送slaveof no
one命令

2989:X 05 Jun 20:16:50.420 \* +failover-state-wait-promotion slave
127.0.0.1:6381 127.0.0.1 6381 \@ taotaoMaster 127.0.0.1 6379 等待升级master

2989:X 05 Jun 20:16:50.515 \# +promoted-slave slave 127.0.0.1:6381 127.0.0.1
6381 \@ taotaoMaster 127.0.0.1 6379 升级6381为master

2989:X 05 Jun 20:16:50.515 \# +failover-state-reconf-slaves master taotaoMaster
127.0.0.1 6379

2989:X 05 Jun 20:16:50.566 \* +slave-reconf-sent slave 127.0.0.1:6380 127.0.0.1
6380 \@ taotaoMaster 127.0.0.1 6379

2989:X 05 Jun 20:16:51.333 \* +slave-reconf-inprog slave 127.0.0.1:6380
127.0.0.1 6380 \@ taotaoMaster 127.0.0.1 6379

2989:X 05 Jun 20:16:52.382 \* +slave-reconf-done slave 127.0.0.1:6380 127.0.0.1
6380 \@ taotaoMaster 127.0.0.1 6379

2989:X 05 Jun 20:16:52.438 \# +failover-end master taotaoMaster 127.0.0.1 6379
故障恢复完成

2989:X 05 Jun 20:16:52.438 \# +switch-master taotaoMaster 127.0.0.1 6379
127.0.0.1 6381 主数据库从6379转变为6381

2989:X 05 Jun 20:16:52.438 \* +slave slave 127.0.0.1:6380 127.0.0.1 6380 \@
taotaoMaster 127.0.0.1 6381 添加6380为6381的从库

2989:X 05 Jun 20:16:52.438 \* +slave slave 127.0.0.1:6379 127.0.0.1 6379 \@
taotaoMaster 127.0.0.1 6381 添加6379为6381的从库

2989:X 05 Jun 20:17:22.463 \# +sdown slave 127.0.0.1:6379 127.0.0.1 6379 \@
taotaoMaster 127.0.0.1 6381 发现6379已经宕机，等待6379的恢复

![](media/d3c3d56b00c99cf37c70ef7dade19462.png)

可以看出，目前，6381位master，拥有一个slave为6380.

接下来，我们恢复6379查看状态：

2989:X 05 Jun 20:35:32.172 \# -sdown slave 127.0.0.1:6379 127.0.0.1 6379 \@
taotaoMaster 127.0.0.1 6381 6379已经恢复服务

2989:X 05 Jun 20:35:42.137 \* +convert-to-slave slave 127.0.0.1:6379 127.0.0.1
6379 \@ taotaoMaster 127.0.0.1 6381 将6379设置为6381的slave

![](media/e891995b115a4c76346629a662b77479.png)

配置多个哨兵
------------

vim sentinel.conf

输入内容：

sentinel monitor taotaoMaster 127.0.0.1 6381 2

sentinel monitor taotaoMaster2 127.0.0.1 6381 1

3451:X 05 Jun 21:05:56.083 \# +sdown master taotaoMaster2 127.0.0.1 6381

3451:X 05 Jun 21:05:56.083 \# +odown master taotaoMaster2 127.0.0.1 6381
\#quorum 1/1

3451:X 05 Jun 21:05:56.083 \# +new-epoch 1

3451:X 05 Jun 21:05:56.083 \# +try-failover master taotaoMaster2 127.0.0.1 6381

3451:X 05 Jun 21:05:56.086 \# +vote-for-leader
3f020a35c9878a12d2b44904f570dc0d4015c2ba 1

3451:X 05 Jun 21:05:56.086 \# +elected-leader master taotaoMaster2 127.0.0.1
6381

3451:X 05 Jun 21:05:56.086 \# +failover-state-select-slave master taotaoMaster2
127.0.0.1 6381

3451:X 05 Jun 21:05:56.087 \# +sdown master taotaoMaster 127.0.0.1 6381

3451:X 05 Jun 21:05:56.189 \# +selected-slave slave 127.0.0.1:6380 127.0.0.1
6380 \@ taotaoMaster2 127.0.0.1 6381

3451:X 05 Jun 21:05:56.189 \* +failover-state-send-slaveof-noone slave
127.0.0.1:6380 127.0.0.1 6380 \@ taotaoMaster2 127.0.0.1 6381

3451:X 05 Jun 21:05:56.252 \* +failover-state-wait-promotion slave
127.0.0.1:6380 127.0.0.1 6380 \@ taotaoMaster2 127.0.0.1 6381

3451:X 05 Jun 21:05:57.145 \# +promoted-slave slave 127.0.0.1:6380 127.0.0.1
6380 \@ taotaoMaster2 127.0.0.1 6381

3451:X 05 Jun 21:05:57.145 \# +failover-state-reconf-slaves master taotaoMaster2
127.0.0.1 6381

3451:X 05 Jun 21:05:57.234 \* +slave-reconf-sent slave 127.0.0.1:6379 127.0.0.1
6379 \@ taotaoMaster2 127.0.0.1 6381

3451:X 05 Jun 21:05:58.149 \* +slave-reconf-inprog slave 127.0.0.1:6379
127.0.0.1 6379 \@ taotaoMaster2 127.0.0.1 6381

3451:X 05 Jun 21:05:58.149 \* +slave-reconf-done slave 127.0.0.1:6379 127.0.0.1
6379 \@ taotaoMaster2 127.0.0.1 6381

3451:X 05 Jun 21:05:58.203 \# +failover-end master taotaoMaster2 127.0.0.1 6381

3451:X 05 Jun 21:05:58.203 \# +switch-master taotaoMaster2 127.0.0.1 6381
127.0.0.1 6380

3451:X 05 Jun 21:05:58.203 \* +slave slave 127.0.0.1:6379 127.0.0.1 6379 \@
taotaoMaster2 127.0.0.1 6380

3451:X 05 Jun 21:05:58.203 \* +slave slave 127.0.0.1:6381 127.0.0.1 6381 \@
taotaoMaster2 127.0.0.1 6380

集群
====

即使有了主从复制，每个数据库都要保存整个集群中的所有数据，容易形成木桶效应。

使用Jedis实现了分片集群，是由客户端控制哪些key数据保存到哪个数据库中，如果在水平扩容时就必须手动进行数据迁移，而且需要将整个集群停止服务，这样做非常不好的。

Redis3.0版本的一大特性就是集群（Cluster），接下来我们一起学习集群。

架构
----

![C:\\Users\\zhijun\\Documents\\My Knowledge\\temp\\4dedc425-875d-454a-a734-51cd20cfb7a6_4_files\\6e54d7ef-7d67-441a-8edf-23d7a93d65c1.jpg](media/e17913fb72aa5aee049017ee2d3132d5.jpg)

(1)所有的redis节点彼此互联(PING-PONG机制),内部使用二进制协议优化传输速度和带宽.

(2)节点的fail是通过集群中超过半数的节点检测失效时才生效.

(3)客户端与redis节点直连,不需要中间proxy层.客户端不需要连接集群所有节点,连接集群中任何一个可用节点即可

(4)redis-cluster把所有的物理节点映射到[0-16383]slot（插槽）上,cluster
负责维护node\<-\>slot\<-\>value

修改配置文件
------------

1.  设置不同的端口，6379、6380、6381

2.  开启集群，cluster-enabled yes

3.  指定集群的配置文件，cluster-config-file "nodes-xxxx.conf"

![](media/4435fff4a35d188414f6c3dd5e054732.png)

创建集群
--------

### 安装ruby环境

因为redis-trib.rb是有ruby语言编写的所以需要安装ruby环境。

yum -y install zlib ruby rubygems

gem install redis

手动安装：

rz上传redis-3.2.1.gem

gem install -l redis-3.2.1.gem

### 创建集群

首先，进入redis的安装包路径下：

cd /usr/local/src/redis/redis-3.0.1/src/

![](media/15106855172b51f94a130f75d67eafa4.png)

执行命令：

./redis-trib.rb create --replicas 0 192.168.56.102:6379 192.168.56.102:6380
192.168.56.102:6381

\--replicas 0：指定了从数据的数量为0

注意：这里不能使用127.0.0.1，否则在Jedis客户端使用时无法连接到！

redis-trib用法：

![](media/c1970b8fb22da5d99e51ac48e8669957.png)

![](media/84a511618a1f1a1b322cd43949de0b84.png)

### 测试

![](media/cb84104b313db6b156600749468ad10e.png)

什么情况？？(error) MOVED 7638 127.0.0.1:6380

因为abc的hash槽信息是在6380上，现在使用redis-cli连接的6379，无法完成set操作，需要客户端跟踪重定向。

redis-cli -c

![](media/bae87ef5974a82140e83f1ad9de0e8f4.png)

看到由6379跳转到了6380，然后再进入6379看能否get到数据

![](media/f7cb1eb9618753876db15709314c6023.png)

还是被重定向到了6380，不过已经可以获取到数据了。

使用Jedis连接到集群
-------------------

添加依赖，要注意jedis的版本为2.7.2

![](media/53ee86da99c5697eb66397331e644630.png)

![](media/32e1da3fabe060ddfa4f93f0e9c35410.png)

说明：这里的jc不需要关闭，因为内部已经关闭连接了。

插槽的分配
----------

通过cluster nodes命令可以查看当前集群的信息：

![](media/329a35a6b466ac838dd1a53c68082690.png)

该信息反映出了集群中的每个节点的id、身份、连接数、插槽数等。

当我们执行set abc 123命令时，redis是如何将数据保存到集群中的呢？执行步骤：

1.  接收命令set abc 123

2.  通过key（abc）计算出插槽值，然后根据插槽值找到对应的节点。（abc的插槽值为：7638）

3.  重定向到该节点执行命令

整个Redis提供了16384个插槽，也就是说集群中的每个节点分得的插槽数总和为16384。

./redis-trib.rb 脚本实现了是将16384个插槽平均分配给了N个节点。

注意：如果插槽数有部分是没有指定到节点的，那么这部分插槽所对应的key将不能使用。

插槽和key的关系
---------------

计算key的插槽值：

key的有效部分使用CRC16算法计算出哈希值，再将哈希值对16384取余，得到插槽值。

什么是有效部分？

1.  如果key中包含了{符号，且在{符号后存在}符号，并且{和}之间至少有一个字符，则有效部分是指{和}之间的部分；

    1.  key={hello}_tatao的有效部分是hello

2.  如果不满足上一条情况，整个key都是有效部分；

    1.  key=hello_taotao的有效部分是全部

新增集群节点
------------

再开启一个实例的端口为6382

![](media/57cc2b8b77cc59e91727e0836854b116.png)

执行脚本：

./redis-trib.rb add-node 192.168.56.102:6382 192.168.56.102:6379

![](media/85a693d3f28a06c7bac4b6445550dab8.png)

已经添加成功！查看集群信息：

![](media/1547a9dc070aa49161b1879669b49c62.png)

发现没有插槽数。

接下来需要给6382这个服务分配插槽，将6379的一部分（1000个）插槽分配给6382：

![](media/d2b3b2af986ed369422c3a0dccd109b3.png)

![](media/ad5d3b0cf8b31a25d95a13b332d50ed1.png)

查看节点情况：

![](media/f7e6379cf048c4bce3b43ccc963edaa9.png)

删除集群节点
------------

想要删除集群节点中的某一个节点，需要严格执行2步：

1.  将这个节点上的所有插槽转移到其他节点上；

    1.  假设我们想要删除6380这个节点

    2.  执行脚本：./redis-trib.rb reshard 192.168.56.102:6380

    3.  选择需要转移的插槽的数量，因为3380有5128个，所以转移5128个  
        

        ![](media/b652875a1111e3858e47d007c233df14.png)

    4.  输入转移的节点的id，我们转移到6382节点：82ed0d63cfa6d19956dca833930977a87d6ddf7

    5.  输入插槽来源id，也就是6380的id

    6.  输入done，开始转移  
        

        ![](media/455fa0bdbec6dc2fba317a0dc1fd0511.png)

    7.  查看集群信息，可以看到6380节点已经没有插槽了。  
        

        ![](media/7f5b745556d0de65d641c64c19f0497e.png)

2.  使用redis-trib.rb删除节点

    1.  ./redis-trib.rb del-node 192.168.56.102:6380
        4a9b8886ba5261e82597f5590fcdb49ea47c4c6c

    2.  del-node host:port node_id

    ![](media/52d2d16f6dda3d362bba9f8568278b56.png)

    1.  查看集群信息，可以看到已经没有6380这个节点了。  
        

        ![](media/b5d72af59ef9b7578d3fd6b7465e0ba2.png)

故障转移
--------

如果集群中的某一节点宕机会出现什么状况？我们这里假设6381宕机。

![](media/1d084a5f00f57fe20327e78da26756f1.png)

![](media/67b33cb6371139a7457d460e26e983b9.png)

我们尝试连接下集群，并且查看集群信息，发现6381的节点断开连接：

![](media/544252f27a0b461965fdf661dd18b28c.png)

我们尝试执行set命令，结果发现无法执行：

![](media/15fed6eb0c74046ebf623570b206550a.png)

什么情况？集群不可用了？？ 这集群也太弱了吧？？

### 故障机制

1.  集群中的每个节点都会定期的向其它节点发送PING命令，并且通过有没有收到回复判断目标节点是否下线；

2.  集群中每一秒就会随机选择5个节点，然后选择其中最久没有响应的节点放PING命令；

3.  如果一定时间内目标节点都没有响应，那么该节点就认为目标节点**疑似下线**；

4.  当集群中的节点超过半数认为该目标节点疑似下线，那么该节点就会被标记为**下线**；

5.  当集群中的任何一个节点下线，就会导致插槽区有空档，不完整，那么该集群将不可用；

6.  如何解决上述问题？

    1.  在Redis集群中可以使用主从模式实现某一个节点的高可用

    2.  当该节点（master）宕机后，集群会将该节点的从数据库（slave）转变为（master）继续完成集群服务；

### 集群中的主从复制架构

架构：

![](media/a3df353d1af40130b486c639d3de3da6.png)

出现故障：

![](media/c8701a67773bd0076108196cedf559e6.png)

### 创建主从集群

需要启动6个redis实例，分别是：

6379（主） 6479（从）

6380（主） 6480（从）

6381（主） 6481（从）

![](media/08ced3bc6c3a16fc6c10210313f15922.png)

启动redis实例：

cd 6379/ && redis-server ./redis.conf && cd ..

cd 6380/ && redis-server ./redis.conf && cd ..

cd 6381/ && redis-server ./redis.conf && cd ..

cd 6479/ && redis-server ./redis.conf && cd ..

cd 6480/ && redis-server ./redis.conf && cd ..

cd 6481/ && redis-server ./redis.conf && cd ..

![](media/11af2f888dce53f592e63d011035546b.png)

创建集群，指定了从库数量为1，创建顺序为主库（3个）、从库（3个）：

./redis-trib.rb create --replicas 1 192.168.56.102:6379 192.168.56.102:6380
192.168.56.102:6381 192.168.56.102:6479 192.168.56.102:6480 192.168.56.102:6481

![](media/8927ff64e5f518d48f5237b66ccee568.png)

![](media/a272b818669689c778dce0c9ab41a8a2.png)

创建成功！查看集群信息：

![](media/a2854d79f812c983f2518b34156b7a10.png)

### 测试

![](media/c85eb68d5aa6b2dae815fce9f88ea7b0.png)

保存、读取数据OK！

查看下6480的从库数据：

![](media/37a353e501b4abdb89e968fe055a31c4.png)

看到从6480查看数据也是被重定向到6380.

说明集群一切运行OK！

### 测试集群中slave节点宕机

我们将6480节点kill掉，查看情况。

![](media/68ee49034467212ed6dabc446defacf7.png)

查看集群情况：

![](media/c08447a28472bed31936940334722e7e.png)

发现6480节点不可用。

那么整个集群可用吗？

![](media/4d7c74c8b1c9aa0517c31c4bd9ebc2ea.png)

发现集群可用，可见从数据库宕机不会影响集群正常服务。

恢复6480服务：

![](media/56c4bdcd226e14ed9a69474534bf112f.png)

测试6480中的数据：

![](media/31e3baf7b23f0416397a967c82c1ad15.png)

看到已经更新成最新数据。

### 测试集群中master宕机

假设6381宕机：

![](media/cc6de651eb3440bc5d851e63ede1bba0.png)

查看集群情况：

![](media/9dde8567dc6a96e9e44c86f71c614656.png)

发现：

1、6381节点失效不可用

2、6481节点从slave转换为master

测试集群是否可用：

![](media/967bb33eae7220beab29f817c8a04b40.png)

集群可用。

恢复6381：

![](media/aa72295f0c4676db529bb26f7273db50.png)

发现：

1、6381节点可用

2、6481依然是主节点

3、6381成为6481的从数据库

使用集群需要注意的事项
----------------------

1.  多键的命令操作（如MGET、MSET），如果每个键都位于同一个节点，则可以正常支持，否则会提示错误。

2.  集群中的节点只能使用0号数据库，如果执行SELECT切换数据库会提示错误。
