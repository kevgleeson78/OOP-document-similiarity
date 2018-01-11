
package ie.gmit.sw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Consumer implements Runnable {
	private BlockingQueue<Shingle> q;
	private int k;
	private int[] minHashes;
	private Map<Integer, List<Integer>> map = new ConcurrentHashMap<Integer, List<Integer>>();
	private ExecutorService pool;

	public Consumer(BlockingQueue<Shingle> q, int k, int poolSize) {
		super();
		this.q = q;
		this.k = k;
		pool = Executors.newFixedThreadPool(poolSize);
		init();
	}

	public void init() {
		Random random = new Random();
		minHashes = new int[k];
		for (int i = 0; i < minHashes.length; i++) {
			minHashes[i] = random.nextInt();

		}
	}

	int docCount = 2;
	float jaccard;
	@Override
	public void run() {
		
		while (docCount > 0) {
			try {

				Shingle s = q.take();
				if (s instanceof Poision) {
					System.out.println("test");
					docCount--;
				}
					else {
						
					
					pool.execute(new Runnable() {
						@Override
						public void run() {
							List<Integer> list = map.get(s.getDocId());
							
							for (int i = 0; i < minHashes.length; i++) {
								int value = s.getHashCode() ^ minHashes[i]; // ^ - xor(Random generated key)

								if (list == null) {
									list = new ArrayList<Integer>(Collections.nCopies(k, Integer.MAX_VALUE));

									map.put(s.getDocId(), list);

								} else {
									if (list.get(i) > value) {
										list.set(i, value);
									}
									map.put(s.getDocId(), list);
									if (docCount==1) {
										
										List<Integer> intersection = new ArrayList<Integer>(map.get(2));
										intersection.retainAll(map.get(1));
										jaccard = (intersection.size())
												/ ((k) + ((float) intersection.size()));
										
									}
									
								}
								
								
								
							}

						}

					});
					
				} 
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Document Similuarity: "+(jaccard * 2) * 100+"%");
	}
	
}
