
package ie.gmit.sw;

import java.util.ArrayList;
import java.util.HashMap;
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
	private Map<Integer, List<Integer>> map = new ConcurrentHashMap<>(k);
	private ExecutorService pool;
	private int docCount = 2;
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
			System.out.println(minHashes);
		}
	}

	@Override
	public void run() {
		try {
			
			while (docCount > 0) {
				Shingle s = q.take();
				if (s instanceof Poision) {
					docCount--;
					
				} else {
					pool.execute(new Runnable() {
						@Override
						public void run() {
							for (int i = 0; i < minHashes.length; i++) {
								int value = s.getHashCode() ^ minHashes[i]; // ^ - xor(Random generated key)
								List<Integer> list = map.get(s.getDocId());
								
								if (list == null) {
									list = new ArrayList<Integer>();
									for (int j = 0; j <minHashes.length; j++) {
										list.add(Integer.MAX_VALUE);
										map.put(s.getDocId(), list);
										
									}
									
									
								} else {
									if (list.get(i) > value) {
										list.set(i, value);

									}
								}
								
								
								if(i ==k-1) {
								List<Integer>intersection = new ArrayList<Integer>(map.get(2));
								intersection.retainAll(map.get(1));
								
								float jaccard =((float)intersection.size())/
										((k)+((float)intersection.size()));
								System.out.println((jaccard*2)*100);
								}
							}
								}
					});
					
					}
			}
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	

}
