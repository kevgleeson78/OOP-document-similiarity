package ie.gmit.sw;

import java.util.Scanner;

public class Menu {
	Scanner scr = new Scanner(System.in);
	private String doc1;
	private String doc2;
	private int shingleSize;
	private int k;
	private int blockingQSize;
	private int thrPoolSize;
	private int option;

	public Menu() {
		doc1 = new String();
		doc2 = new String();
		shingleSize = 0;
		k = 0;
		blockingQSize = 0;
		thrPoolSize = 0;
		option = 0;
	}
	GetDoc gDoc = new GetDoc();
	public void show() {
		while (option!=7) {
			System.out.println("");
			System.out.println("Main Menu");
			System.out.println("---------------------------");
			System.out.println("1. Enter Document 1");
			System.out.println("2. Enter Document 2");
			System.out.println("3. Shingle Size");
			System.out.println("4. Value of k");
			System.out.println("5. Blocking Queue Size");
			System.out.println("6. Thread Pool Size");
			System.out.println("7. exit program");
			System.out.println("----------------------------");
			System.out.println("");
			System.out.print("Please select an option from 1-7");
			System.out.println("");
			System.out.println("");
			
			option = scr.nextInt();
			switch (option) {
			case 1:
				System.out.println("please enter the first document url");
				doc1 = scr.next();
				gDoc.setPath(doc1);
				doc1 = gDoc.getPath();
				System.out.println(doc1);
				break;
			case 2:
				System.out.println("please enter the second document url");
				doc2 = scr.next();
				gDoc.setPath(doc2);
				doc2 = gDoc.getPath();
				System.out.println(doc2);
				break;
			case 3:
				System.out.println("Please enter the Shingle size.");
				shingleSize = scr.nextInt();
				break;
			case 4:
				System.out.println("Please enter the value fro k (amount of minhash).");
				k = scr.nextInt();
				break;
			case 5:
				System.out.println("Please enter the size of the Blocking Queue.");
				blockingQSize = scr.nextInt();
				break;
			case 6:
				System.out.println("Please enter the ThreadPool Size.");
				thrPoolSize = scr.nextInt();
				break;
			case 7:
				System.out.println("option 7");
				break;
			default:
				System.out.println("invalid input...");
				break;
			}
		}
	}
	
}
