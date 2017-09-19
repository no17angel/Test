package Demo.DesignMode;

import java.io.IOException;

/**
* @Title: 单例
* @Description: 各种单例，线程安全示例
* @author lei.wang
* @date 2017年9月19日 上午10:14:45 
* @version v1.0
 */
public class Demo extends Thread {
	private int type = 0;
	public Demo(int type){
		this.type = type;
	}
	
	@Override
	public void run() {
		switch (type) {
		case 1:
			System.out.println("饿汉" + Singleton.getInstance().hashCode());
			break;
		case 2:
			System.out.println("懒汉" + Singleton.getInstance().hashCode());
			break;
		default:
			System.out.println("输入值：" + type + "，Demo不存在。");
			break;
		}
	}

	
	public static void main(String[] args) {
		System.out.println( "请输入模式对应的数字!" );
		System.out.println( "1.饿汉单例模式" );
		System.out.println( "2.懒汉单例模式" );
        int n = 0;
		try {
			n = System.in.read();
			System.out.println(".................................");
			System.out.println( "输入内容："+(char)n );
			System.out.println(".................................");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Demo[] mts = new Demo[10];
		for (int i = 0; i < mts.length; i++) {
			mts[i] = new Demo(Integer.valueOf((char)n+""));
		}
		
		for (int j = 0; j < mts.length; j++) {
			mts[j].start();
		}
	}
}
