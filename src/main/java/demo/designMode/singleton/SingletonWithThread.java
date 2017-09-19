package demo.designMode.singleton;

/**
 * 懒汉式单例模式
 * @author lei.wang
 *
 */
public class SingletonWithThread {

	private static SingletonWithThread instance = null;

	private SingletonWithThread() {
	}

	// 出现非线程安全问题，是由于多个线程可以同时进入getInstance()方法，那么只需要对该方法进行synchronized的锁同步即可
	public synchronized static SingletonWithThread getInstance() {
		try {
			if (instance != null) {// 懒汉式

			} else {
				// 创建实例之前可能会有一些准备性的耗时工作
				Thread.sleep(100);
				instance = new SingletonWithThread();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return instance;
	}
}
