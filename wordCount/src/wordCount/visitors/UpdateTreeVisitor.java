package wordCount.visitors;
import wordCount.dsForStrings.Node;
import wordCount.dsForStrings.Trie;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;

/**
 *  [Visitor that updates occurrence of all word in original tree ]
 *  Also notify all listener node on each update
 */ 
public class UpdateTreeVisitor implements DSProcessingVisitorI {

	private FileProcessor fileProcessor;
	private Trie backupTree;
	private StringBuilder sb;
	private String fileOriginal, fileUpdated, fileBackup;
	
	public UpdateTreeVisitor (String fileOriginalIn, String fileUpdatedIn, String fileBackupIn, Trie backupTreeIn) {
		fileOriginal = fileOriginalIn;
		fileUpdated = fileUpdatedIn;
		fileBackup = fileBackupIn;
		backupTree = backupTreeIn;
		Logger.writeMessage("DEBUG_VALUE = 0 [UpdateTreeVisitor's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
	}
	
	private void traverse(Node node, boolean isUpdate) {
		if(node.getCount() > 0) { 
			if(isUpdate) {
				// Increment count and notify observer  on update
				node.incrementCount(); 
				node.notifyObserver();	
			}
			else { 
				// Format output to be printed on file
				sb.append(node.getWord() + " : " + node.getCount() + "\n");
			}
		}
		for(int i = 0; i < node.getMaxChild(); i++) {	
			if(node.getChild(i) != null)
				traverse(node.getChild(i), isUpdate);
		}
	}
	
	@Override
	public void visit(Trie tree) {
	
		// Open File and write words and occurrence before update
		fileProcessor = new FileProcessor(FileProcessor.FileOperation.WRITE, fileOriginal);
		sb = new StringBuilder();
		traverse(tree.getRootNode(), false);
		fileProcessor.writeFile(sb.toString());
		fileProcessor.closeFile();
		
		// Open File and write words and occurrence after update
		fileProcessor = new FileProcessor(FileProcessor.FileOperation.WRITE, fileUpdated);
		traverse(tree.getRootNode(), true);
		sb = new StringBuilder();
		traverse(tree.getRootNode(), false);
		fileProcessor.writeFile(sb.toString());
		fileProcessor.closeFile();
		
		// Open File and write words and occurrence from the clone tree
		fileProcessor = new FileProcessor(FileProcessor.FileOperation.WRITE, fileBackup);
		sb = new StringBuilder();
		traverse(backupTree.getRootNode(), false);
		fileProcessor.writeFile(sb.toString());
		fileProcessor.closeFile();
	}
}