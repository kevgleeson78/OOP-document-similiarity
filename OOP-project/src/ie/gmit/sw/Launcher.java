package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Launcher {
	
	Menu m = new Menu();
	
	public void launch(String f1, String f2) throws Exception{
		BlockingQueue<Shingle> q = new LinkedBlockingQueue<>(20);
		Thread t1 = new Thread(new DocumentParser(f1,q,5,10),"T1");
		Thread t2 = new Thread(new DocumentParser(f2, q, 5, 10), "T2");
		Thread t3 = new Thread(new Consumer( q,5,10),"T3");
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
	}
}
