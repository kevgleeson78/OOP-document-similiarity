package ie.gmit.sw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jaccard extends MinHash {

	

	private int docCount;

	private float jaccard ;

	public Jaccard() {
		super();
		docCount = 2;
		jaccard = 0;
	}

	public void run() {

		while (docCount > 0) {
			try {

				Shingle s = q.take();
				if (s instanceof Poision) {
					
					docCount--;
				} else {

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

									setJaccard();

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

		System.out.println("Document Similarity: " + (jaccard * 2) * 100 + "%");
	}
	
	public void setJaccard() {
		
	if(docCount==1) {
				List<Integer> intersection = new ArrayList<Integer>(map.get(2));
				intersection.retainAll(map.get(1));
				jaccard = (intersection.size()) / ((k) + ((float) intersection.size()));
	
	}
			
		}

}