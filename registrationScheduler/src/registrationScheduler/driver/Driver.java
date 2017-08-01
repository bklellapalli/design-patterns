package registrationScheduler.driver;
import registrationScheduler.coursesRegistration.Scheduler;
import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.store.Results;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.util.CourseObjectPool;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.ObjectPool;
public class Driver{
	
	/**
	   * Allocate courses to students using multiple threads. 
	   * and the command line arguments.
	   * @param arg A string containing the command line arguments.
	   * @exception NumberFormatException, InterruptedException
	   * @return No return value.
	   */ 
	public static void main(String[] args) {		
		try {
			// Validate that the correct number of arguments passed.
			if(args.length != 4) {
				System.err.println("Format: java Driver input.txt output.txt <NUM_THREADS> <DEBUG_VALUE>");
				System.exit(0);
			}
			// Validate that the value of NUM_THREADS is between 1 and 3. 
			if(Integer.valueOf(args[2]) < 1 || Integer.valueOf(args[2]) > 3) {
				System.err.println("<NUM_THREADS> has to be between 1 and 3.");
				System.exit(0);
			}
			// Validate that the DEBUG_VALUE is between 0 and 4. 
			if(Integer.valueOf(args[3]) < 0 || Integer.valueOf(args[3]) > 4) {
				System.err.println("<DEBUG_VALUE> has to be between 0 and 4.");
				System.exit(0);
			}
			// Set Debug value
			Logger.setDebugValue(Integer.valueOf(args[3]));
			// writeSchedulesToFile
			FileDisplayInterface result = new Results();
			
			FileProcessor readFileProcessor = new FileProcessor(FileProcessor.FileOperation.READ, args[0]);
			CreateWorkers worker = new CreateWorkers(readFileProcessor, result, new Scheduler());
			worker.startWorkers(Integer.valueOf(args[2]));
			// Close file processor used for reading
			readFileProcessor.closeFile(); 		
			
			FileProcessor writeFileProcessor = new FileProcessor(FileProcessor.FileOperation.WRITE, args[1]);
			result.writeSchedulesToFile(writeFileProcessor);
			// Close file processor used for writing
			writeFileProcessor.closeFile(); 
			
			// Print the schedules, average preference score, etc.
			((StdoutDisplayInterface)result).writeScheduleToScreen();
			
			// Clear Courses from Course object pool
			ObjectPool objectPool = CourseObjectPool.getObjectPoolInstance();
			objectPool.clear();
			objectPool.close();
		}
		catch(NumberFormatException ex) {
			System.err.println("<NUM_THREADS> has to be a number.");
			ex.printStackTrace();
			System.exit(0);
		}
		catch(InterruptedException ex) {
			System.out.println("Thread is interrupted, either before or during the activity.");
			ex.printStackTrace();
			System.exit(0);
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
			System.exit(0);
		}
	}
}