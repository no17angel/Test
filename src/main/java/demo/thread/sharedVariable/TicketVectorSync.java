package demo.thread.sharedVariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
	private List<String> listsync = Collections.synchronizedList(new ArrayList<String>());
	
	@Override
	public void run() {
		try {
			// vector/synchronizedList 需要与 synchronized 共同使用，才能保证线程安全
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
					Thread.sleep(100);
					vector.add(1);
				}
				listNull.add(1);
				if (!list.contains(1)) {
					Thread.sleep(100);
					list.add(1);
				}
				if (!listsync.contains(1)) {
					Thread.sleep(100);
					listsync.add("");
				}
				System.out.println("次数：" + countInt + "：" + Thread.currentThread().getName() + "vectorNull.size()="
						+ vectorNull.size() + "：" + "vector.size()=" + vector.size() + "：" + "listNull.size()="
						+ listNull.size() + "：list.size()=" + list.size() + "：listsync.size()=" + listsync.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] arg) {
		TicketVectorSync ticket = new TicketVectorSync();
		for (int i = 0; i < 9; i++) {
			new Thread(ticket, "线程" + (i + 1) + "：").start();
		}
	}
}
