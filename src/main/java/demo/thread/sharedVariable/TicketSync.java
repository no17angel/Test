package demo.thread.sharedVariable;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Title: 抢票
 * @Description: 使用同步代码块实现线程安全
 * @author lei.wang
 * @date 2017年9月20日 下午1:54:50
 * @version v1.0
 */
public class TicketSync implements Runnable {
	// 共享变量
	private int ticket = 10;
	private AtomicInteger count = new AtomicInteger(0);

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			// 添加同步快
			synchronized (this) {
				if (this.ticket > 0) {
					try {
						// 通过睡眠线程来模拟出最后一张票的抢票场景
						Thread.sleep(100);
						System.out.println("次数：" + count.incrementAndGet() + "：" + Thread.currentThread().getName()
								+ "卖票---->" + (this.ticket--));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] arg) {
		TicketSync ticket = new TicketSync();
		for (int i = 0; i < 4; i++) {
			new Thread(ticket, "线程" + (i + 1) + "：").start();
		}
	}
}
