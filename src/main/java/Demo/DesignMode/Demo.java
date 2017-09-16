package Demo.DesignMode;

public class Demo extends Thread {
	@Override
	public void run() {
		System.out.println(Singleton.getInstance().hashCode());
	}

	public static void main(String[] args) {

		Demo[] mts = new Demo[10];
		for (int i = 0; i < mts.length; i++) {
			mts[i] = new Demo();
		}
		
		for (int j = 0; j < mts.length; j++) {
			mts[j].start();
		}
	}
}
