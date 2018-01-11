package ie.gmit.sw;
/*App Name: Document Jaccard Index Api
 * @Autor Kevin Gleeson
 * Version: 1.0
 * Date: 11/01/2018
 * 
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.BlockingQueue;
//class to parse the document and split each word after a space
//runnable to used with the threads in launcher class
public class DocumentParser implements Runnable {
	private int docId;
	private Deque<String> buffer = new LinkedList<>();
	private BlockingQueue<Shingle> q;
	private String file;
	private int ss;
//Constructor to take in each user file q ,shingle minhas and docid
	public DocumentParser(String file, BlockingQueue<Shingle> q, int ss, int k, int docId) {
		super();

		this.docId = docId;
		this.q = q;
		this.file = file;
		this.ss = ss;

	}

	@Override
	public void run() {

		try {
			//buffered reader to parse text file
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = null;
			//Loop to go file line by line until empty
			while ((line = br.readLine()) != null) {
				//convert all text to upper case
				String uLine = line.toUpperCase();
				//array of words split at a space
				String[] words = uLine.split("");
				//ad words to method
				addWordsToBuffer(words);
				//create shingle object
				Shingle s = getNextShingle();
				//put object in queue
				q.put(s);

			}
			//poision queue once finished
			q.put(new Poision(docId, 0));
			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addWordsToBuffer(String[] words) {
		for (String s : words) {
			buffer.addLast(s);

		}

	}

	private Shingle getNextShingle() {
		StringBuilder sb = new StringBuilder();
		int counter = 0;
		while (counter < ss) {
			if (buffer.peek() != null) {
				sb.append(buffer.poll());
				counter++;

			}
		}

		if (sb.length() > 0) {
//Convert each shingle to hash code
			return (new Shingle(docId, sb.toString().hashCode()));

		} else {

			return null;
		}

	}

}
