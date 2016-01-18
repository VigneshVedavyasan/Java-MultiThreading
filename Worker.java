package JavaThreads;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Worker {
	Object lock1 = new Object();
	Object lock2 = new Object();
	private Random random = new Random();
	
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	
	public void stageOne(){
		synchronized(lock1){
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list1.add(random.nextInt());
		
	}
	}
	
	public void stageTwo(){
		synchronized(lock2){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(random.nextInt());
	}
	}
	public void process(){
		for(int i=0;i<1000;i++){
			stageOne();
			stageTwo();
		}
	}

	public void main() {
		Long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				process();
			}});
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				process();
			}});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Starting...");

		Long end = System.currentTimeMillis();
		System.out.println("Time taken : " + (end-start));
		System.out.println(" List 1 : "+list1.size()+"\n List 2 : "+list2.size());

	}

}
