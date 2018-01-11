
package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;

public class Consumer extends Jaccard implements Runnable {
	public Consumer(BlockingQueue<Shingle> q, int k, int poolSize) {
		super();
		this.q = q;
		this.k = k;
		pool = Executors.newFixedThreadPool(poolSize);
		init();
	}
	
}
