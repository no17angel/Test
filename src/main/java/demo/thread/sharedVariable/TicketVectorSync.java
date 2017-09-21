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
public class TicketVectorSync implements Runnable {
	// 共享变量
	private AtomicInteger count = new AtomicInteger(0);
	private Vector<Integer> vectorNull;
	private Vector<Integer> vector = new Vector<Integer>();
	private ArrayList<Integer> listNull;
	private ArrayList<Integer> list = new ArrayList<Integer>();

	@Override
	public void run() {
		// 当出现竞态条件（if判断）时，vector一样不能保共享变量数据准确
		synchronized (this) {
			int countInt = count.incrementAndGet();
			if (vectorNull == null) {
				vectorNull = new Vector<Integer>();
			}
			if (listNull == null) {
				listNull = new ArrayList<Integer>();
			}
			vectorNull.add(1);
			if (!vector.contains(1)) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				vector.add(1);
			}
			listNull.add(1);
			if (!list.contains(1)) {
				try {
					Thread.sleep(100);
					list.add(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("次数：" + countInt + "：" + Thread.currentThread().getName() + "vectorNull.size()="
					+ vectorNull.size() + "：" + "vector.size()=" + vector.size() + "：" + "listNull.size()="
					+ listNull.size() + "：list.size()=" + list.size());
		}
	}

	public static void main(String[] arg) {
		TicketVectorSync ticket = new TicketVectorSync();
		for (int i = 0; i < 9; i++) {
			new Thread(ticket, "线程" + (i + 1) + "：").start();
		}
	}
}
