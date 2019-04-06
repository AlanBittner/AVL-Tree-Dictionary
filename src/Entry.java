
public class Entry implements Comparable<Entry> {
	private String word;
	private String definition;
	
	public Entry() {
		
	}
	
	public Entry(String word) {
		this.word=word;
		this.definition=" ";
	}
	
	public Entry(String word, String definition) {
		this.word=word;
		this.definition=definition;
	}

	public String getWord() {
		return word;
	}
	
	public String getDefinition() {
		return definition;
	}
	
	public void setDefinition(String x) {
		this.definition=x;
	}
	
	public String toString() {
		return word + " " + definition + "\n";
	}
	
	
	public int compareTo(Entry x) {
		return word.compareToIgnoreCase(x.word);
	}

		
	
}
