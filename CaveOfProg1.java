package JavaThreads;

public class CaveOfProg1 {
	public static void main(String[] args) throws InterruptedException{
		final Processor4 processor4 = new Processor4();
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				try {
					processor4.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				try {
					processor4.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();

	}
}
