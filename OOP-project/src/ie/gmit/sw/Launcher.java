package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/*App Name: Document Jaccard Index Api
 * @Autor Kevin Gleeson
 * Version: 1.0
 * Date: 11/01/2018
 * 
 */
class Launcher {

//The class for starting threads
	//with all of the user value entered in the constructor.

	
	
	
	public void launch(String f1, String f2, int shingleSize, int k, int tps) throws Exception {
		
		BlockingQueue<Shingle> q = new LinkedBlockingQueue<>();
		Thread t1 = new Thread(new DocumentParser(f1, q, shingleSize, 1), "T1");

		Thread t2 = new Thread(new DocumentParser(f2, q,shingleSize, 2), "T2");

		Thread t3 = new Thread(new Consumer(q, k, tps), "T3");
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		
		

	}

}
