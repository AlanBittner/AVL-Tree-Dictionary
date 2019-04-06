import java.util.Scanner;

public class Dictionary {
	AVLTree dictionary = new AVLTree();

	public static void main(String[] args) {
		
		Boolean cont=true;
		String input;
		
		while(cont) {
			input=menuInput();
			switch(input) {
				case"f":
					//findEntry();
					//break;
				case"i":
					//insertEntry();
					//break;
				case"l":
					//loadDictionary();
					//break;
				case"p":
					//printDictionary();
					//break;
				case"r":
					//removeDictionary();
					//break;
				case"s":
					//saveDictionary();
					System.out.println(input);
					break;
				case"x":
					cont=false;
					break;
				default:
					System.out.println("Unexpected Value.");
			}
		}
		System.out.println("Thanks for using the dictionary.");

	}

	public static void displayMenu() {
		System.out.println("Possible operations:");
		System.out.println("f) Find the meaning of a word.");
		System.out.println("i) Insert an entry.");
		System.out.println("l) Load the dictionary from an input file.");
		System.out.println("p) Print all the entries.");
		System.out.println("r) Remove an entry.");
		System.out.println("s) Save the contents of the dictionary in an output file.");
		System.out.println("x) Exit.");
		System.out.print("Please choose an option (f, i, l, p, r, s, or x):");
	}
	
	public static String menuInput() {
		Scanner kb = new Scanner(System.in);
		String input=null;
		
		displayMenu();
		input=kb.nextLine();
		input.toLowerCase();
		
		return input;
	}
	
}
