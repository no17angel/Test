package Demo.DesignMode.Singleton;

/**
 * 懒汉式单例模式
 * @author lei.wang
 *
 */
public class SingletonNoThread {

	private static SingletonNoThread instance = null;

	private SingletonNoThread() {
	}

	public static SingletonNoThread getInstance() {
		try {
			if (instance != null) {// 懒汉式

			} else {
				// 创建实例之前可能会有一些准备性的耗时工作
				Thread.sleep(100);
				instance = new SingletonNoThread();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return instance;
	}
}
