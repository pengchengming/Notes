/**
 * 
 */
package com.pcm.singleton.demo4;

/**  
* @Package com.pcm.Singleton.demo4 
* @Title: Singleton.java   
* @Description: TODO
* 4、双检锁/双重校验锁（DCL，即 double-checked locking）
  JDK 版本：JDK1.5 起
       是否 Lazy 初始化：是
       是否多线程安全：是
       实现难度：较复杂
        描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
   getInstance() 的性能对应用程序很关键。  
* @author pcm  
* @date 2018年6月28日 下午4:59:14
* @version V1.0  
*/
public class Singleton {
	private volatile static Singleton singleton;

	private Singleton() {
	}

	public static Singleton getSingleton() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (null == singleton) {
                     singleton = new Singleton();
				}
			}
		}
		return singleton;
	}

}
