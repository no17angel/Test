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
public class TicketVector implements Runnable {
	// 共享变量
	private int ticket = 10;
	private AtomicInteger count = new AtomicInteger(0);
	private Vector vector;
	private Vector vector2 = new Vector<>();;
	private ArrayList list = new ArrayList();

	@Override
	public void run() {
		// 当出现竞态条件（if判断）时，vector一样不能保共享变量数据准确
		synchronized (this) {
			int countInt = count.incrementAndGet();
			if (vector == null) {
				try {
					vector = new Vector();
					vector.add(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			vector2.add(1);
			list.add(1);
			System.out.println("次数：" + countInt + "：" + Thread.currentThread().getName() + "vector.size()="
					+ vector.size() + "：" + "vector2.size()=" + vector2.size() + "：" + "list.size()=" + list.size());
		}
	}

	public static void main(String[] arg) {
		TicketVector ticket = new TicketVector();
		for (int i = 0; i < 4; i++) {
			new Thread(ticket, "线程" + (i + 1) + "：").start();
		}
	}
}
