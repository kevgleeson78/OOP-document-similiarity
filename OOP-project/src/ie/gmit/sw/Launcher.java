package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Launcher {



	
	
	
	public void launch(String f1, String f2,int shingleSize,int k,int bqs,int tps) throws Exception {
		
		BlockingQueue<Shingle> q = new LinkedBlockingQueue<>();
		Thread t1 = new Thread(new DocumentParser(f1, q, shingleSize, k, 1), "T1");

		Thread t2 = new Thread(new DocumentParser(f2, q,shingleSize, k, 2), "T2");

		Thread t3 = new Thread(new Consumer(q, k, tps), "T3");
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		
		

	}

}
