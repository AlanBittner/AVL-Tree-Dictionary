
public class Test {
	
	public static void main(String[] args) {
		
		AVLTree Dictionary = new AVLTree();
		Entry E1 = new Entry("a", "blah");
		Entry E2 = new Entry("b", "blah");
		Entry E3 = new Entry("c", "blah");
		Entry E4 = new Entry("d", "blah");
		Entry E5 = new Entry("e", "blah");
		Entry E6 = new Entry("f", "blah");
		Entry E7 = new Entry("g", "blah");
		Entry E8 = new Entry("h", "blah");
		Entry E9 = new Entry("i", "blah");
		Entry E10 = new Entry("j", "blah");
		Entry E11 = new Entry("k", "blah");
		Entry E12 = new Entry("l", "blah");
		Entry E13 = new Entry("m", "blah");
		Entry E14 = new Entry("n", "blah");
		
		
		
		Entry EF = new Entry("G");
		Node TF = new Node(EF);
		
		//Node T1 = new Node(E1);
		//Node T2 = new Node(E2);
	//	Node T3 = new Node(E3);
		/*
		 * for(int i=1; i<=14 ; i++) { String x="E" +i; Dictionary.insert(x); }
		 */
		
		System.out.println("1");
		
		Dictionary.insert(E1);
		Dictionary.insert(E2);
		Dictionary.insert(E3);
		Dictionary.insert(E4);
		Dictionary.insert(E5);
		Dictionary.insert(E6);
		Dictionary.insert(E7);
		Dictionary.insert(E8);
		Dictionary.insert(E9);
		Dictionary.insert(E10);
		Dictionary.insert(E11);
		Dictionary.insert(E12);
		Dictionary.insert(E13);
		Dictionary.insert(E14);
		
		Dictionary.insert(E1);
		
		System.out.println("2");
		
		System.out.println(Dictionary.saveTree());
		
		System.out.println("3");
		
		//System.out.println(Dictionary.find(EF, Dictionary.getRoot()));
		
		Dictionary.printTree();
		System.out.println();
	//	System.out.println(Dictionary.findMinNode(Dictionary.getRoot()));
		System.out.println();
		Dictionary.remove(E5);
		
		//System.out.println(Dictionary.getRoot());
		Dictionary.printTree();
		
	//	System.out.println(Dictionary.find(TF, Dictionary.getRoot()));
		
		System.out.println("End");
		
		
		
	}
	
}
