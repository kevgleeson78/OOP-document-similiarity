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

	public void show() {
		while (option!=7) {
			System.out.println("");
			System.out.println("Main Menu");
			System.out.println("---------------------------");
			System.out.println("1. See submenu 1");
			System.out.println("2. See submenu 2");
			System.out.println("3. See submenu 3");
			System.out.println("4. See submenu 4");
			System.out.println("5. See submenu 5");
			System.out.println("6. See submenu 6");
			System.out.println("7. exit program");
			System.out.println("----------------------------");
			System.out.println("");
			System.out.print("Please select an option from 1-7");
			System.out.println("");
			System.out.println("");
			
			option = scr.nextInt();
			switch (option) {
			case 1:
				System.out.println("option 1");
				break;
			case 2:
				System.out.println("option 2");
				break;
			case 3:
				System.out.println("option 3");
				break;
			case 4:
				System.out.println("option 4");
				break;
			case 5:
				System.out.println("option 5");
				break;
			case 6:
				System.out.println("option 6");
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
