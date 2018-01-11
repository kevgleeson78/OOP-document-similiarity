package ie.gmit.sw;
/*App Name: Document Jaccard Index Api
 * @Autor Kevin Gleeson
 * Version: 1.0
 * Date: 11/01/2018
 * 
 */

//import scanner class
import java.util.Scanner;

public class Menu {
	
	//getters setters
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
		return tps;
	}
	public void setTps(int tps) {
		this.tps = tps;
	}
	public int getBlockingQSize() {
		return blockingQSize;
	}
	public void setBlockingQSize(int blockingQSize) {
		this.blockingQSize = blockingQSize;
	}
	//new scanner
	Scanner scr = new Scanner(System.in);
	//Variables for user input
	private String doc1;
	private String doc2;
	private int shingleSize;
	private int k;
	private int blockingQSize;
	private int tps;
	private String option;

	public Menu() {
		doc1 = new String();
		doc2 = new String();
		shingleSize = 0;
		k = 0;
		blockingQSize = 0;
		tps = 0;
		option =  new String();
	}
	//New doc object
	GetDoc gDoc = new GetDoc();
	//Show method for menu to be used in main class
	public void show() throws Exception {
		while (!option.equalsIgnoreCase("8")) {
			//sysout the ui menu
			System.out.println("");
			System.out.println("Main Menu");
			System.out.println("---------------------------");
			System.out.println("1. Enter Document 1");
			System.out.println("2. Enter Document 2");
			System.out.println("3. Shingle Size (6 Recomended for large files)");
			System.out.println("4. Value of k (200 - 300 recomended)");
			System.out.println("5. Blocking Queue Size");
			System.out.println("6. Thread Pool Size");
			System.out.println("7. Launch  program");
			System.out.println("----------------------------");
			System.out.println("");
			System.out.print("Please select an option from 1-7");
			System.out.println("");
			System.out.println("");
			//Take in option
			option = scr.next();
			
			//Switch staements for user input
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
				this.setShingleSize(shingleSize);
				break;
			case "4":
				System.out.println("Please enter the value for k (amount of minhash).");
				k = scr.nextInt();
				this.setK(k);
				break;
			case "5":
				System.out.println("Please enter the size of the Blocking Queue.");
				blockingQSize = scr.nextInt();
				this.setBlockingQSize(blockingQSize);
				break;
			case "6":
				System.out.println("Please enter the ThreadPool Size.");
				tps = scr.nextInt();
				this.setTps(tps);
				break;
			case "7":
				System.out.println("option 7");
				new Launcher().launch(doc1, doc2,shingleSize,k,blockingQSize,tps);
				break;
			default:
				System.out.println("invalid input...");
				break;
			}
		}
	}
	
}
