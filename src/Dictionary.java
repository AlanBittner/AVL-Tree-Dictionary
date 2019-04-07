import java.util.Scanner;

public class Dictionary {
	private static AVLTree dictionary = new AVLTree();

	public static void main(String[] args) {
		
		Boolean cont=true;
		String input;
		
		while(cont) {
			input=menuInput();
			switch(input) {
				case"f":
					findEntry();
					break;
				case"i":
					insertEntry();
					break;
				case"l":
					//loadDictionary();
					//break;
				case"p":
					printDictionary();
					break;
				case"r":
					removeEntry();
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
	
	public static void findEntry() {
		Scanner kb = new Scanner(System.in);
		System.out.print("\nEnter the word you would like to find: ");
		
		Entry find = new Entry(kb.nextLine());
		Node found= dictionary.find(find);
		if(found==null) {
			System.out.println("Sorry that entry does not exist.");
		}else {
			System.out.println(found);
		}
		
	}
	
	
	public static void insertEntry() {
		Scanner kb = new Scanner(System.in);
		System.out.print("\nEnter the word you would like to add to the dictionary: ");
		String word=kb.nextLine();
		//System.out.println();
		Entry newEntry = new Entry(word);
		if(dictionary.find(newEntry)==null) {
			System.out.print("\nPlease enter the definition of the word: ");
			String definition = kb.nextLine();
			newEntry.setDefinition(definition);
			dictionary.insert(newEntry);
		}
		else {
			System.out.println("\nThe word you entered already exists in the dictionary.");
		}
		
	}
	
	public static void printDictionary() {
		dictionary.printTree();
	}
	
	public static void removeEntry() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter the name of the entery you want to remove: ");
		String word = kb.nextLine();
		Entry element= new Entry(word);
		dictionary.remove(element);
	}
	
}
