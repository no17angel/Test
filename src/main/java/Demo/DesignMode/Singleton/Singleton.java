package Demo.DesignMode.Singleton;

/**
 * 饿汉式单例模式
 * @author lei.wang
 *
 */
public class Singleton {
	// 饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的。
	private static Singleton singleton = new Singleton();
	
	// 私有无惨构造，防止new对象
	private Singleton(){};
	
	public static Singleton getInstance(){
		return singleton;
	}
}
