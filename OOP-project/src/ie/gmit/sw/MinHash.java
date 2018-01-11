package ie.gmit.sw;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

public class MinHash {

	protected BlockingQueue<Shingle> q;
	protected int k;
	protected int[] minHashes;
	protected Map<Integer, List<Integer>> map = new ConcurrentHashMap<>(k);
	protected ExecutorService pool;

	public MinHash() {
		super();
	}

	public void init() {
		Random random = new Random();
		minHashes = new int[k];
		for (int i = 0; i < minHashes.length; i++) {
			minHashes[i] = random.nextInt();
	
		}
	}

}