package wordCount.visitors;
import wordCount.dsForStrings.Trie;

/**
 * [visitor interface]
 */ 
public interface DSProcessingVisitorI {
	public void visit(Trie tree);
}