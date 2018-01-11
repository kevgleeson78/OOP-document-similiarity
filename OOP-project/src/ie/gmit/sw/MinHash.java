package ie.gmit.sw;
/*App Name: Document Jaccard Index Api
 * @Autor Kevin Gleeson
 * Version: 1.0
 * Date: 11/01/2018
 * 
 */
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
//Class to generate minhashes
public class MinHash {

	protected BlockingQueue<Shingle> q;
	protected int k;
	protected int[] minHashes;
	protected Map<Integer, List<Integer>> map = new ConcurrentHashMap<Integer, List<Integer>>();
	protected ExecutorService pool;

	public MinHash() {
		super();
	}

	public void init() {
		//Generate Random int
		Random random = new Random();
		//create array of k length
		minHashes = new int[k];
		for (int i = 0; i < minHashes.length; i++) {
			//Store a random int in the array
			minHashes[i] = random.nextInt();
	
		}
	}

}