This file contains all the Names and definitions of all the classes and functions for the Dictionary program.

Public class Entry
	- This class stores a word and a definition of that word.

	Constructors: This class has three different constructors. First creates blank Entry, the secound create an entry with just a word and no definition, and the third created an Entry that has a word and a definition.

	Functions:
	
		getWord - returns the variable word.

		getDefinition - returns the variable definition.

		setDefinition - changes the variable definition.

		toString - Defines how the Entry class can be pushed to a string.

		compareTo - Defines how to compare different Entries.


Public Class Node
	- This class is used as our nodes(or vertices) in our AVLTree class, which uses variables leftNode and rightNode to link to other nodes, and height to assist with the balancing of the tree. It stores any type of data in item. 

	Constructors: This class has two constructors, the first just created node with null for all values but height, the secound constructor creates a node with whatever information you want to place in the item variable.

	Functions:

		compareTo - Defines how to compare two different nodes, by comparing the item stored in the nodes.

		getLeft - returns the node that is linked in leftNode variable.

		setLeft - sets the value of leftNode.

		getRight - returns the node that is linked in rightNode variable.

		setRight - sets the value of rightNode.

		getHeight - returns the integer value of height.

		setHeight - sets the value of height.

		getItem - returns the object stored at variable item.

		setItem - sets an object at variable item.

		toString - Defines how Node is to handle being sent to a string, which is to return how ever the item in the node handles toString.

Public Class AVLTree
	- This class is where Nodes are stored and Functions to manipulate the tree exist.

	Constructor: The class has only one constructor which sets up an empty AVL Tree.

	Fuctions:

		getRoot - returns the value stores at the variable root.

		setRoot - assign a value to the variable root.

		find - there are two versions of this function:
			1st, takes in a value we want to find in our tree and then uses the secound use of our find function to start the find function at the root of our tree.
			2nd, is a recursive function that takes in a comparable item, and node in the AVL Tree, if the node matches the comparable item or is null it returns the node, else it compares if the item is lesser or greater and and applies the find function to the appropriate left or right node.

		insert - There are two versions of this function
			1st, takes in a comparable item and applies the 2nd version of the insert function at the root level. It eventually returns the complete tree.
			2nd, takes in a comparable item and a node. It them compares the item to the current node, if the node is null, it creates a node with that comparable stored in it and returns the new node. if the node is the same as the comparable it spits out an error and then returns the node unchanged. if the comparable is lesser or greater than the node, it applies the insert function to the appropriate left or right node, and eventually returns the subtree of itself and all its children. If a difference of height between its left and right nodes greater than 1, the function with balance the tree by rotating the nodes.

		rotateWithLeftNode - This function balances the tree when when the left node has a greater height than right node, and the left child of the left node has a greater height than the right child.

		rotateWithRightNode - This function balances the tree when the right node has a greater height than the left node, and the right child of the right node has a greater height than the left child.

		doubleWithLeftNode - This function balances the tree when the left node has a greater height than the right node, and the right child of the left node has a greater height than the left child.

		doubleWithRightNode - This function balances the tree when the right node has a greater height than the left node, and the left child of the right node has a greater height than the right child.

		printTree - This function has two versions:
			1st, used the 2nd form of the function setting the node to the root.
			2nd, is an infix recursive function that goes through the tree and prints out all the entries in order.

		getHeight - returns the height of the node, if the node is null, returns -1.

		remove - This function has two versions:
			1st, takes in a comparable item and uses it with the secound form of the function using the root node, it sets the root of the tree to new form of the tree.
			2nd, recieves a comparable item and a node, if the node is null, it returns null; if the node equals the comparable it replaces the item of this node with the smallest item in the subtree of the right node. It then balances the tree if balancing is needed. it returns the subtree of the node and below.

		findMinNode - find the node that has the smallest value, passing to the left node until the left node is null, then passing back up the node value.

		saveTree - This function has two versions:
			1st, sets the secound version of the function to the root node, returns a string that contains all the nodes in the tree in prefix notation.
			2nd, a prefix notation recursive function places 


Public Class Dictionary
	- This class acts as a dictionary using the AVLTree class as a a way to store entries. It contains a main function, that gives the user options for finding, inserting, loading, printing, removing, printing and saving the dictionary.

	Functions:

	main - This function uses the menuInput function to receive an input from the user to know how the user wants to manipulate the dictionary.

	displayMenu - this function simply prints out all the menu options, used to make the input function cleaner to read.

	menuInput - Displays the menu options, and takes an input from the user, which it changes to lowercase and returns that input to the main function.

	findEntry - This function searches the dictionary for whatever the user inputs, if the entry is there, it prints the word and definition, if its not, it gives the user the appropriate message.

	insertEntry - Asks the user what word they would like to add to the dictionary, if the word isn't in the dictionary yet, it asks for the definition then inserts the word and definition in the tree.

	printDictionary - Prints out all the entries in the Dictionary in alphabetical order.

	removeEntry - asks the user what word they want to remove, and removes it if it exists in the dictionary.

	saveDictionary - asks the user where they want to save the dictionary, and saves the dictionary to a file of that name in prefix order.

	loadDictionary - asks the user where they want to load their dictionary from, and reads the file line by line adding each entry to the dictionary.