package demo.thread.sharedVariable;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Title: Vector 线程同步集合
 * @Description: 不使用同步代码块实现线程安全，会出现超卖
 * @author lei.wang
 * @date 2017年9月20日 下午1:54:50
 * @version v1.0
 */
public class TicketVector2 implements Runnable {
	// 共享变量
	private AtomicInteger count = new AtomicInteger(0);
	private Vector<Integer> vector;
	private Vector<Integer> vector2 = new Vector<Integer>();
	private ArrayList<Integer> list = new ArrayList<Integer>();

	@Override
	public void run() {
		// 当出现竞态条件（if判断）时，vector一样不能保共享变量数据准确
		int countInt = count.incrementAndGet();
		if (vector == null) {
			vector = new Vector<Integer>();
			vector.iterator();
			vector.add(1);
		}
		vector2.add(1);
		list.add(1);
		System.out.println("次数：" + countInt + "：" + Thread.currentThread().getName() + "vector.size()=" + vector.size()
				+ "：" + "vector2.size()=" + vector2.size() + "：" + "list.size()=" + list.size());
	}

	public static void main(String[] arg) {
		TicketVector2 ticket = new TicketVector2();
		for (int i = 0; i < 4; i++) {
			new Thread(ticket, "线程" + (i + 1) + "：").start();
		}
	}
}
