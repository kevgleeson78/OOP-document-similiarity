package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;

public class Runner {
	public static void main(String[] args) {

		try {
			new Launcher().launch(
					"C:\\Users\\kevin\\Desktop\\College Folders\\Object Orientated Programming\\Project\\new1.txt",
					"C:\\Users\\kevin\\Desktop\\College Folders\\Object Orientated Programming\\Project\\new2.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}