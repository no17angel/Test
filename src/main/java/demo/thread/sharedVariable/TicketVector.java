package demo.thread.sharedVariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Title: Vector 线程同步集合
 * @Description: 不使用同步代码块实现线程安全
 * @author lei.wang
 * @date 2017年9月20日 下午1:54:50
 * @version v1.0
 */
public class TicketVector implements Runnable {
	// 共享变量
	private AtomicInteger count = new AtomicInteger(0);
	private Vector<Integer> vectorNull;
	private Vector<Integer> vector = new Vector<Integer>();
	private static ArrayList<Integer> listNull;
	private static ArrayList<Integer> list = new ArrayList<Integer>();
	private List<String> listsync = Collections.synchronizedList(new ArrayList<String>());

	@Override
	public void run() {
		// 当出现竞态条件（if判断）时，vector一样不能保共享变量数据准确
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
		if (!listsync.contains(1)) {
			try {
				Thread.sleep(100);
				listsync.add("");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("次数：" + countInt + "：" + Thread.currentThread().getName() + "vectorNull.size()="
				+ vectorNull.size() + "：" + "vector.size()=" + vector.size() + "：" + "listNull.size()="
				+ listNull.size() + "：list.size()=" + list.size() + "：listsync.size()=" + listsync.size());
	}

	public static void main(String[] arg) {
		TicketVector ticket = new TicketVector();
		for (int i = 0; i < 9; i++) {
			new Thread(ticket, "线程" + (i + 1) + "：").start();
		}
	}
}
