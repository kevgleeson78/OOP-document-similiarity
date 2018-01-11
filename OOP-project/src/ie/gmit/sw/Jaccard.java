package ie.gmit.sw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jaccard extends MinHash {

	public int getDocCount() {
		return docCount;
	}

	public void setDocCount(int docCount) {
		this.docCount = docCount;
	}

	public float getJaccard() {
		return jaccard;
	}

	public void setJaccard(float jaccard) {
		this.jaccard = jaccard;
	}

	int docCount = 2;

	float jaccard = 0;

	public Jaccard() {
		super();
	}

	public void run() {

		while (docCount > 0) {
			try {

				Shingle s = q.take();
				if (s instanceof Poision) {
					System.out.println("test");
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
		do {

			List<Integer> intersection = new ArrayList<Integer>(map.get(2));
			intersection.retainAll(map.get(1));
			jaccard = (intersection.size()) / ((k) + ((float) intersection.size()));

		} while (docCount > 0);
		
	}

}