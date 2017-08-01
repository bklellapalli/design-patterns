package wordCount.driver;
import wordCount.dsForStrings.Trie;
import wordCount.util.FileProcessor;
import wordCount.visitors.CloneAndObserverVisitor;
import wordCount.visitors.DSProcessingVisitorI;
import wordCount.visitors.PopulateVisitor;
import wordCount.visitors.UpdateTreeVisitor;
import wordCount.visitors.WordCountVisitor;

public class Driver {
	/**
	   * "wc" command with Visitor, Prototype, and Observer 
	   * @param arg argument for input file name, output file name and NUM_ITERATIONS.
	   * @exception NumberFormatException
	   */ 
	public static void main(String[] args) {
		try {
			
			// (1) Validate that command line inputs for input and output file names.
			if(args.length != 3) {
				System.err.println("Format: java Driver input.txt output.txt <NUM_ITERATIONS>");
				System.exit(0);
			}
			
			int NUM_ITERATIONS = Integer.valueOf(args[2]);
			if(NUM_ITERATIONS < 1) {
				System.err.println("<NUM_ITERATIONS> has to be a (+)ve number.");
				System.exit(0);
			}			
			
			// (2) Create the element(s)
			Trie orgnlTree =  null;		
			long startTime = System.currentTimeMillis();
			
			for (int i = 0; i < NUM_ITERATIONS; i++) {
				
				orgnlTree = new Trie();			
				FileProcessor reader = new FileProcessor(FileProcessor.FileOperation.READ, args[0]);
				FileProcessor writer = new FileProcessor(FileProcessor.FileOperation.WRITE, args[1]);

				// (3) Create the two visitor instances
				DSProcessingVisitorI populateVisitor = new PopulateVisitor(reader);
				DSProcessingVisitorI wordCountVisitor = new WordCountVisitor(writer);

				orgnlTree.accept(populateVisitor);
				orgnlTree.accept(wordCountVisitor);

				reader.closeFile();
				writer.closeFile(); 
			}
			
			// (4) Use the performance measurement loop given above.
			long finishTime = System.currentTimeMillis();
			System.out.println("Total Time : " + (finishTime-startTime)/NUM_ITERATIONS + " ms");		

			// (5) Visitor that clones the data structure so that it can be used as a backup.
			Trie backupTree = new Trie();
			DSProcessingVisitorI cloneVisitor = new CloneAndObserverVisitor(backupTree);
			orgnlTree.accept(cloneVisitor);

			// (6) visitor that updates the integer value in all the nodes of the original tree.
			DSProcessingVisitorI updateTreeVisitor = new UpdateTreeVisitor("result_original.txt", 
					"result_updated.txt", "result_backup.txt", backupTree);
			orgnlTree.accept(updateTreeVisitor);
		}
		catch(NumberFormatException ex) {
			System.err.println("<NUM_ITERATIONS> has to be a number.");
			ex.printStackTrace();
			System.exit(0);
		}
	}
}