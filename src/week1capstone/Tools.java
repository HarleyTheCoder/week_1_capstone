package week1capstone;

public class Tools {

	//Split a sentence into separate words
	//could make them lowercase but doing extended challenge
	public static String[] splitWords(String input) {
		String[] nxtWord = input.split(" ", -2);
		return nxtWord;
	}
	
	//Check if a letter is a vowel
	public static boolean isVowel(String letter) {
		String[] vowels = {"a", "e", "i", "o", "u"};
		for (int i = 0; i < vowels.length; i++) {
			if (letter.equalsIgnoreCase(vowels[i])) {
				return true;
			}
		}
		return false;
	}
	
	//METHOD TO TAKE OUT NON ALPHANUMERICAL STUFF, OR PUT IT AT THE END
	public static String fixNonAlpha (String word) {
		if (word.contains("'")) {
			word = word.replaceAll("'", "");
		}
			//I couldn't figure out a way to use the switch statement using the contains() method, so I used if else
		if (word.contains(".") || word.contains("!") || word.contains("?") || word.contains(",") || word.contains(";")) {
			if (word.contains(".")) {
				word = word.replace(".", "") + ".";
			} else if (word.contains("!")) {
				word = word.replace("!", "") + "!";
			} else if (word.contains("?")) {
				word = word.replace("?", "") + "?";
			} else if (word.contains(",")) {
				word = word.replace(",", "") + ",";
			} else if (word.contains(";")) {
				word = word.replace(";", "") + ";";
			}
		}
		return word;
	}

	public static String translateWord(String word) {
		String newWord = "";
		String checkSpecial = ("[0123456789@#$%&*()_+=|<>{}\\\\[\\\\]~-]");
		boolean anyVowels = false;
		
		//First makes sure there are no special non-grammatical characters
		for (int i = 0; i < checkSpecial.length(); i ++) {
			try {
				if (word.contains(checkSpecial.substring(i, i + 1))) {
					return word;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				if (word.contains(checkSpecial.substring(i))) {
					newWord = word;
					return word;
				}
			}
			
		}
			
		//Makes sure there are vowels in word, to ensure words like "my" come out right.
		for (int i = 0; i < word.length(); i++) {
			if (i == word.length() - 1 && isVowel(word.substring(i))) {
				anyVowels = true;
			} else if (isVowel(word.substring(i, i + 1))) {
				anyVowels = true;
			}
		}
		
		//Edits words after finding vowel
		if (isVowel(word.substring(0, 1))) {
			newWord = word + "way";
		} else {
			for (int i = 0; i < word.length(); i++) {  
				if (!anyVowels) {
					newWord = word + "ay";
				} else if (isVowel(word.substring(i, i + 1))) {
					String txtBegin = word.substring(0, i);
					String txtEnd = word.substring(i);
					newWord = txtEnd + txtBegin + "ay";
					break;
				}
			}
		}
		//Check to make sure the case and certain characters are correct
		newWord = fixCase(word, newWord);
		newWord = fixNonAlpha(newWord);
		
		//return output
		return newWord;
	} 
	
	
	//Makes sure the word stays in the correct case.
	public static String fixCase(String word, String newWord) {
		if (word.equals(word.toUpperCase())) {
			return newWord.toUpperCase();
		} else if (word.substring(0, 1).equals(word.substring(0, 1).toUpperCase())) {
			String fixed = newWord.substring(0, 1).toUpperCase() + newWord.substring(1).toLowerCase();
			return fixed;
		} else {
			return newWord.toLowerCase();
		}
	}
	
	//This fixes the word "I" in some cases, also "A".
	public static String[] checkForIA (String[] words) {
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals("IWAY")) {
				if (words.length == 1 || (i == words.length - 1 && words[i - 1].equals(words[i - 1].toLowerCase())) ||
					!words[i + 1].equals(words[i + 1].toUpperCase())) {
						words[i] = "Iway";
				}
			} else if (words[i].equals("AWAY") && (i == words.length - 1 || i == 0)) {
					words[i] = "AWAY";
				}
			}
		return words;
		}
	//(Idk if ALL possible inputs will work perfectly with that,
	//but this is an extra thing and I'm already being a perfectionist, so BAM.)
	
	//I'll spend all day on a code if I let myself lol.
	
	//DISPLAY ALL WORDS AFTER
	public static void printWords(String[] words) {
		System.out.println("");
		for (int i = 0; i < words.length; i++) {
			System.out.print(words[i] + " ");
		}
	}
	
	
}