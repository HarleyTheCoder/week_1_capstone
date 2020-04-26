package week1capstone;

import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the Pig Latin Translator!");
		
		//"Continue" loop starts here
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
			
			//Put words into an array to edit them separately
			String[] words = Tools.splitWords(input); 
			for (int i = 0; i < words.length; i++) {
					words[i] = Tools.translateWord(words[i]);
			}
			
			/*
			-This next line fixes the case where I becomes IWAY when it shouldn't,
			or cases where The first word is "A" so it becomes "AWAY", but
			the rest isn't capitalized.
			-The decision takes into consideration whether other parts of the sentence
			are capitalized or not.
			
			-I'm not an expert in pig latin, I'm inventing a couple grammar rules, so
			using "I" in a sentence will usually become "Iway" rather than "iway".
			 */
			words = Tools.checkForIA(words);

			//Display words
			Tools.printWords(words);
			
			//Continue or nay
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