package ie.gmit.sw;

/*App Name: Document Jaccard Index Api
 * @Autor Kevin Gleeson
 * Version: 1.0
 * Date: 11/01/2018
 * 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jaccard extends MinHash {

	// Calculate Jaccard Index.

	private int docCount;

	private float jaccard;

	public Jaccard() {
		super();
		docCount = 2;
		jaccard = 0;
	}

	public void run() throws Exception{

		while (docCount > 0) {
			try {
//Take Shingle from queue
				Shingle s = q.take();
				if (s instanceof Poision) {
//if queue has been poisioned
					docCount--;
				} else {
//New Thread Pool
					pool.execute(new Runnable() {
                                            @Override
                                            public void run() {
                                                List<Integer> list = map.get(s.getDocId());
                                                
                                                for (int i = 0; i < minHashes.length; i++) {
                                                    //Get hash code of minHases
                                                    int value = s.getHashCode() ^ minHashes[i]; // ^ - xor(Random generated key)
                                                    
                                                    if (list == null) {
                                                        list = new ArrayList<>(Collections.nCopies(k, Integer.MAX_VALUE));
                                                        //Put the DocId and MinHashes to the list
                                                        map.put(s.getDocId(), list);
                                                        
                                                    } else {
                                                        if (list.get(i) > value) {
                                                            list.set(i, value);
                                                        }
                                                        map.put(s.getDocId(), list);
                                                        // The setJAccard method
                                                        setJaccard();
                                                        
                                                    }
                                                    
                                                }
                                            }
                                        });
					// Print out the result to the user
					
				}

			} catch (InterruptedException e) {
                            // TODO Auto-generated catch block

			}
			
		}
			Callable<String> callable = () -> {// Print out the result to the user
		 return "Document Similarity: " + (jaccard * 2) * 100 + "%";
                };
                     ExecutorService executorService = Executors.newSingleThreadExecutor();                                                            
        System.out.println("Submitting Callable");
        Future<String> future = executorService.submit(callable);

        // This line executes immediately
        System.out.println("Do something else while callable is getting executed");

        System.out.println("Retrieve the result of the future");
        // Future.get() blocks until the result is available
        
           
               String result = future.get();
            
        System.out.println(result);

        //executorService.shutdown();
	}

	// SetJaccard Method
	public void setJaccard() {

		if (docCount ==1) {
			// get Results from the Comparrison
			List<Integer> intersection = new ArrayList<>(map.get(2));
			intersection.retainAll(map.get(1));
			jaccard = (intersection.size()) / ((k) + ((float) intersection.size()));
			
		}
		
	}

}