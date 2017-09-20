package demo.thread.sharedVariable;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Title:抢票-原子变量
 * @Description: 使用原子变量实现线程安全
 * @author lei.wang
 * @date 2017年9月20日 下午1:54:50
 * @version v1.0
 */
public class TicketAtomic implements Runnable {
	// 共享变量
	private AtomicInteger ticket = new AtomicInteger(10);
	private AtomicInteger count = new AtomicInteger(0);// 纯计数的操作可以保证数据正确

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			// 当出现竞态条件（if判断）时，原子变量一样不能保证线程安全
			if (this.ticket.get() > 0) {
				try {
					// 通过睡眠线程来模拟出最后一张票的抢票场景
					Thread.sleep(100);
					System.out.println("次数：" + count.incrementAndGet() + "：" + Thread.currentThread().getName()
							+ "卖票---->" + (this.ticket.decrementAndGet())); // 纯计数的操作可以保证数据正确
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] arg) {
		TicketAtomic ticket = new TicketAtomic();
		for (int i = 0; i < 4; i++) {
			new Thread(ticket, "线程" + (i + 1) + "：").start();
		}
	}
}
