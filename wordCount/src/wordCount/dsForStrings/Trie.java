package wordCount.dsForStrings;
import wordCount.util.Logger;
import wordCount.visitors.DSProcessingVisitorI;

public class Trie {
	
	private Node root =  null;
	private int findIndex(char ch) {
		int index = 0;
		// Array index [0 - 25]
		if(ch >= 'a' && ch <= 'z') { index = ch - 'a'; }
		// Array index [26 - 51]
		else if(ch >= 'A' && ch <= 'Z') { index = ch - 'A' + 26; }
		// Array index [52 - 61]
		else if (ch >= '0' && ch <= '9') { index = ch - '0' + 52; }
		return index;
	}
	
	public Trie() { 
		root = new Node(); 
		Logger.writeMessage("DEBUG_VALUE=0 [Trie's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * Returns root of the tree
	 * @return root node
	 */
	public Node getRootNode() {	return root; }
	
	/**
	 * Insert word in Tree 
	 * @param word that need to be inserted in tree
	 */
	public void insert(String word) { 
		 Node node = root;
		 for(int i = 0; i < word.length(); i++){
			 int index =  findIndex(word.charAt(i));
			 if(node.getChild(index) != null) {
				 // Traverse to child node
				 node = node.getChild(index);
			 }
			 else {
				 // Create new node as no child node found.
				 Node newNode = new Node();
				 node.setChild(index, newNode);
				 node = newNode;	
			}
		 }
		 node.setWord(word);
	}
	
	public void accept(DSProcessingVisitorI visitor) {
		visitor.visit(this);
	}
}