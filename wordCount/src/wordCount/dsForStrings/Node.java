package wordCount.dsForStrings;
import java.util.ArrayList;
import java.util.List;
import wordCount.util.Logger;

public class Node implements Cloneable, ObserverI, SubjectI {

	private String word;
	private int count, maxChild;
	private Node [] child; 
	private List<Node> observerList;
	
	public Node() {
		maxChild = 62;
		child = new Node [maxChild];
		Logger.writeMessage("DEBUG_VALUE=0 [Node's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * Returns Maximum child nodes a node can have.
	 * @return Number of child nodes
	 */
	public int getMaxChild() { return maxChild; }
	
	/**
	 * Returns Word that is stored in a node.
	 * @return Word stored in node
	 */
	public String getWord() { return word; }
	public void setWord(String str) { 
		word = str; 
		++count;
	}
	
	/**
	 * Returns occurrence of the Word.
	 * @return Word's occurrence 
	 */
	public int getCount() { return count; }
	public void incrementCount() { ++count; }
	
	/**
	 * Returns child node on index
	 * @param Index value
	 * @return Node in Array at the specific index
	 */
	public Node getChild(int index) { return child[index]; }
	public void setChild(int index, Node node) { 
		child[index] = node; 
	}
	
	/**
	 * Register backup node as listener for the node (Subject)
	 * @param backup node
	 */
	public void registerObserver(Node clone) {
		if(observerList == null) {
			observerList = new ArrayList<Node>();
		}
		observerList.add(clone);
	}
	
	/**
	 * Unregister backup node as listener for the node (Subject)
	 * @param backup node
	 */
	public void removeObserver(Node clone) {
		if(observerList.contains(clone)) {
			observerList.remove(clone);
		}
	}
	
	/**
	 * Notify backup node if there is any change in original node
	 */
	public void notifyObserver() {
		if(observerList == null) return;
		for(int i = 0; i < observerList.size(); i++) {
			observerList.get(i).update(this);
		}
	}
	
	/**
	 * Update backup node (occurrence) with value of original node (occurrence)
	 * @param original node
	 */
	public void update(Node orgnlNode) { count = orgnlNode.count; }
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Node newNode = new Node();
		newNode.word = word;
		newNode.count = count;
		return newNode;	
	}
	
	@Override
	public String toString() {
		return "Node [word=" + word + ", count=" + count + "]";
	}
}