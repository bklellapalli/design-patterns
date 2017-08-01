package wordCount.visitors;
import wordCount.dsForStrings.Node;
import wordCount.dsForStrings.Trie;
import wordCount.util.Logger;

/**
 *  [Visitor that clone each node from the tree and form back up tree 
 *  Also register each node of the tree (Observer pattern)
 */ 
public class CloneAndObserverVisitor implements DSProcessingVisitorI {
		
	private Trie backupTree;
	public CloneAndObserverVisitor(Trie backupTreeIn) {
		backupTree = backupTreeIn;
		Logger.writeMessage("DEBUG_VALUE = 0 [CloneAndObserverVisitor's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
	}
	
	private void preOrderTraverse(Node node, Node clone) throws CloneNotSupportedException {
		for(int i = 0; i < node.getMaxChild(); i++) {	
			if(node.getChild(i) != null) {		
				// Clone node
				Node cloneNode = (Node) node.getChild(i).clone();
				// Register observer node
				node.getChild(i).registerObserver(cloneNode);			
				// Set child node
				clone.setChild(i, cloneNode);
				preOrderTraverse(node.getChild(i), cloneNode);
			}
		}
	}
	
	@Override
	public void visit(Trie trieNode) {
		try {		
			preOrderTraverse(trieNode.getRootNode(), backupTree.getRootNode());			
		} 
		catch (CloneNotSupportedException ex) {
			System.err.println("Failed to clone object.");
			ex.printStackTrace();
			System.exit(0);
		}
	}
}