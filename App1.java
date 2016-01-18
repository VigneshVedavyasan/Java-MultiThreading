package JavaThreads;

class Runner implements Runnable{
	public void run(){
		for(int i=0;i<10;i++){
			if(Thread.currentThread().getName()=="T1")
				System.out.println("T1 :");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
					e.printStackTrace();
			}
				
			System.out.println("Printing i, " +i);
			
		}
		

	}
}
public class App1 {

	public static void main(String[] args) {
		Runner runner1 = new Runner();
		Thread t1 = new Thread(runner1);
		t1.setName("T1");
		Runner runner2 = new Runner();
		Thread t2 = new Thread(runner2);
		t2.setName("T2");
		t1.start();
		t2.start();

	}

}
