package week1capstone;

import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the Pig Latin Translator!");
		
		//Loop starts here
		while (true) {
			
			System.out.print("\nEnter a line to be translated: ");
			
			String cont;
			String input = scan.nextLine();
			
			while (true ) {
				if (input == "") {
					System.out.println("\nPlease enter text: ");
					input = scan.nextLine();
				} else {
					break;
				}
			}
			
			
			String[] words = Tools.splitWords(input); 
			for (int i = 0; i < words.length; i++) {
					words[i] = Tools.translateWord(words[i]);
			}


			Tools.printWords(words); //test
			
			System.out.print("\n\nTranslate another line? (y/n): ");
			while (true) {
				cont = scan.nextLine().toLowerCase();
				if (cont.startsWith("y") || cont.startsWith("n")) {
					break;
				} else {
					System.out.println("\nPlease indicate with \"y\" or \"n\": ");
				}
			}
			if (cont.startsWith("n")) {
				break;
			}
			
		}
		scan.close();
	}
	
}
		
	