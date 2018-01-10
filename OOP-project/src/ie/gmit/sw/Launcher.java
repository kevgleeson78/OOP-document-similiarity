package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Launcher {

	public void launch(String f1, String f2) throws Exception {
		BlockingQueue<Shingle> q = new LinkedBlockingQueue<>(2);
		Thread t1 = new Thread(new DocumentParser(f1, q, 6, 200, 1), "T1");

		Thread t2 = new Thread(new DocumentParser(f2, q, 6, 200, 2), "T2");

		Thread t3 = new Thread(new Consumer(q, 200, 8), "T3");

		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();

		// Jaccard index

		/*
		 * List<Integer>intersection = new ArrayList<Integer>(a);
		 * intersection.retainAll(b);
		 * 
		 * float jaccard =((float)intersection.size())/
		 * ((200*2)+((float)intersection.size())); System.out.println(jaccard);
		 */

	}

}
