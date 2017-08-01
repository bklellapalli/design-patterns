package wordCount.visitors;
import wordCount.dsForStrings.Node;
import wordCount.dsForStrings.Trie;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;

/**
 *  [Visitor that determines the total number of words, total number of unique words, 
 *  and characters stored in the data structure]
 */ 
public class WordCountVisitor implements DSProcessingVisitorI {

	private int wordCount;
	private int distinctWordcount;
	private int charCount;
	private FileProcessor fileProcessor;
	
	public WordCountVisitor(FileProcessor fileProcessorIN) {
		fileProcessor = fileProcessorIN;
		Logger.writeMessage("DEBUG_VALUE = 0 [WordCountVisitor's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
	}
	
	private void preOrderTraverse(Node node) {
		if(node.getCount() > 0) {
			// Count word, distinct word and character count
			wordCount += node.getCount();
			++distinctWordcount;
			charCount += (node.getWord().length() * node.getCount());
		}
		for(int i = 0; i < node.getMaxChild(); i++) {	
			if(node.getChild(i) != null)
				preOrderTraverse(node.getChild(i));
		}
	}
	
	@Override
	public void visit(Trie tree) {
		preOrderTraverse(tree.getRootNode());
		fileProcessor.writeFile("Word Count : " + wordCount + "\nDistinct Word Count : " + 
				distinctWordcount + "\nCharacter Count : " + charCount);
	}
}