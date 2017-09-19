package demo.designMode.singleton;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Title: 单例
 * @Description: 各种单例，线程安全示例，通过输出类的hashcode判定单例是否为相同的类
 * @author lei.wang
 * @date 2017年9月19日 上午10:14:45
 * @version v1.0
 */
public class Demo extends Thread {
	private int type = 0;
	private static int count = 100; // 循环一百次，创建100次对象
	private static CountDownLatch latch = new CountDownLatch(count);

	public Demo(int type) {
		this.type = type;
	}

	@Override
	public void run() {
		try {
			switch (type) {
			case 1:
				System.out.println("饿汉" + Singleton.getInstance().hashCode());
				break;
			case 2:
				System.out.println("懒汉" + SingletonNoThread.getInstance().hashCode());
				break;
			case 3:
				System.out.println("懒汉+同步锁" + SingletonWithThread.getInstance().hashCode());
				break;
			default:
				System.out.println("输入值：" + type + "，Demo不存在。");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		latch.countDown();
	}

	public static void main(String[] args) {
		System.out.println("请输入模式对应的数字!");
		System.out.println("1.饿汉单例模式");
		System.out.println("2.懒汉单例模式");
		System.out.println("3.懒汉+同步锁单例模式");
		int n = 0;
		try {
			n = System.in.read();
			System.out.println(".................................");
			System.out.println("输入内容：" + (char) n);
			System.out.println(".................................");
		} catch (IOException e) {
			e.printStackTrace();
		}

		Demo[] mts = new Demo[count];
		for (int i = 0; i < mts.length; i++) {
			mts[i] = new Demo(Integer.valueOf((char) n + ""));
		}
		long time = System.currentTimeMillis();
		for (int j = 0; j < mts.length; j++) {
			mts[j].start();
		}
		try {
			latch.await();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(".................................");
		System.out.println("耗时：" + (System.currentTimeMillis() - time) + "毫秒");
	}
}
