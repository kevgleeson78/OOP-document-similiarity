package ie.gmit.sw;

import java.util.Scanner;

public class Menu {
	public int getShingleSize() {
		return shingleSize;
	}
	public void setShingleSize(int shingleSize) {
		this.shingleSize = shingleSize;
	}
	public int getK() {
		return k;
	}
	public void setK(int k) {
		this.k = k;
	}
	public int getThrPoolSize() {
		return thrPoolSize;
	}
	public void setThrPoolSize(int thrPoolSize) {
		this.thrPoolSize = thrPoolSize;
	}
	public int getBlockingQSize() {
		return blockingQSize;
	}
	public void setBlockingQSize(int blockingQSize) {
		this.blockingQSize = blockingQSize;
	}
	Scanner scr = new Scanner(System.in);
	private String doc1;
	private String doc2;
	private int shingleSize;
	private int k;
	private int blockingQSize;
	private int thrPoolSize;
	private String option;

	public Menu() {
		doc1 = new String();
		doc2 = new String();
		shingleSize = 0;
		k = 0;
		blockingQSize = 0;
		thrPoolSize = 0;
		option =  new String();
	}
	GetDoc gDoc = new GetDoc();
	public void show() throws Exception {
		while (!option.equalsIgnoreCase("8")) {
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
			
			option = scr.next();
			switch (option) {
			case "1":
				System.out.println("please enter the first document url");
				scr.nextLine();
				doc1 = scr.nextLine();
				gDoc.setPath(doc1);
				doc1 = gDoc.getPath();
				
				break;
			case "2":
				System.out.println("please enter the second document url");
				scr.nextLine();
				doc2 = scr.nextLine();
				gDoc.setPath(doc2);
				doc2 = gDoc.getPath();
				
				break;
			case "3":
				System.out.println("Please enter the Shingle size.");
				shingleSize = scr.nextInt();
				break;
			case "4":
				System.out.println("Please enter the value for k (amount of minhash).");
				k = scr.nextInt();
				setK(k);
				break;
			case "5":
				System.out.println("Please enter the size of the Blocking Queue.");
				int bqs = scr.nextInt();
				setBlockingQSize(bqs);
				break;
			case "6":
				System.out.println("Please enter the ThreadPool Size.");
				int thrPoolSize = scr.nextInt();
				setThrPoolSize(thrPoolSize);
				break;
			case "7":
				System.out.println("option 7");
				new Launcher().launch(doc1, doc2);
				break;
			default:
				System.out.println("invalid input...");
				break;
			}
		}
	}
	
}
