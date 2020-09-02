import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The MorseCodeConverter contains a static MorseCodeTree object and constructs (calls the constructor for) the MorseCodeTree.
This class has two static methods convertToEnglish to convert from morse code to English. One method is passed a string
object (“.-.. --- ...- . / .-.. --- --- -.- ...”).  The other method is passed a file to be converted.  These static methods
use the MorseCodeTree to convert from morse code to English characters.  Each method returns a string object of English 
characters.There is also a static printTree method that is used for testing purposes – to make sure the tree for 
MorseCodeTree was built properly.
@author Walid Boutellis
*/
public class MorseCodeConverter {
	
	public static MorseCodeTree myTree= new MorseCodeTree();
	
	/**Default constructor*/
	MorseCodeConverter(){
		
	}
	
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’. 
	 * @param code- The Morse code to be converted
	 * @return A String representation of the English conversion */
	public static String convertToEnglish(String code) {
		String translation= "";
		String [] words= code.split("/");
		for(int i= 0; i< words.length; i++) {
			String temp= words[i].trim();
			translation += convertWord(temp);
			translation += " ";
		}
		return translation.trim();
	}
	
	/**
	 * Helper Method: Converts Morse code into English. Each letter is delimited by a space (‘ ‘). 
	 * @param code- The Morse code to be converted
	 * @return A String representation of the English conversion */
	static String convertWord(String code) {
		
		 String translation= ""; 
		 String [] temp= code.split(" "); 
		 for(int i= 0; i <temp.length; i++) { 
			 translation += myTree.fetch(temp[i]); 
			 }
		 return translation;
	}
	
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’. 
	 * @param codeFile- name of the File that contains Morse Code
	 * @return A String representation of the English conversion 
	 * @throws FileNotFoundException*/
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		String temp = "";
		Scanner sc= new Scanner(codeFile);
		while(sc.hasNextLine()) {
			temp+= sc.nextLine();
		}
		return convertToEnglish(temp);
	}
	
	/**
	 *  Returns a string with all the data in the tree in LNR order with an space in between them.
	 *  Uses the toArrayList method in MorseCodeTree It should return the data in this order: 
	 *  "h s v i f u e l r a p w j b d x n c k y t z g q m o" 
	 *  @return a String of all the elements of the tree*/
	public static String printTree() {
		String temp= "";
		for(String str: myTree.toArrayList()) {
			temp += str + " ";
		}
		temp.trim();
		return temp;
	}
}
