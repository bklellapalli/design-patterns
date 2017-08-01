package wordCount.visitors;
import java.util.StringTokenizer;
import wordCount.dsForStrings.Trie;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;

/**
 * [Visitor class that reads words from a file and populates a data structure]
 */ 
public class PopulateVisitor implements DSProcessingVisitorI {

	private FileProcessor fileProcessor;
	public PopulateVisitor(FileProcessor fileProcessorIN) {
		fileProcessor = fileProcessorIN;
		Logger.writeMessage("DEBUG_VALUE = 0 [CloneAndObserverVisitor's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
	}
	
	@Override
	public void visit(Trie tree) {	
		String line;
		while((line = fileProcessor.readFile()) != null) {		
			// Check for all white spaces
			StringTokenizer token = new StringTokenizer(line, "[ \t]+");
			while(token.hasMoreTokens()) {
				tree.insert(token.nextToken());
			}
		}
	}
}