package JavaThreads;
import java.util.concurrent.atomic.AtomicInteger;
public class App3 {
	private AtomicInteger count = new AtomicInteger();
	public static void main(String[] args){
		App3 app3 = new App3();
		app3.doWork();
	}
	public void doWork(){
		Thread t1 = new Thread(new Runnable(){
		public void run(){
			for(int i=0;i<10000;i++){
				count.incrementAndGet();
			}
		}
		});
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<10000;i++){
					count.incrementAndGet();
				}
			}
			});
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("The value of count is: " + count);
	}
	

}
