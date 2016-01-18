package JavaThreads;

import java.util.Scanner;

class Processor extends Thread{
	private volatile boolean running = true;
	public void run(){
		while(running){
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void shutdown(){
		running = false;
	}
}
public class App2 {

	public static void main(String[] args) {
		Processor proc1 = new Processor();
		proc1.start();
		System.out.println("Press ENTER to close the thread");
		Scanner s1 = new Scanner(System.in);
		s1.nextLine();
		
		proc1.shutdown();
		

	}

}
