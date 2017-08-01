package registrationScheduler.threadMgmt;
import registrationScheduler.coursesRegistration.IScheduler;
import registrationScheduler.coursesRegistration.IStudent;
import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
/**
 * class WorkerThread: Allocate threads & cause threads to execute
 * @author Balakrishna
 */
public class WorkerThread implements Runnable  {

	private FileProcessor fileProcessor = null;
	private FileDisplayInterface result = null;
	private IScheduler scheduler = null;
	
	/**
	 * Allocates a new WorkerThread object
	 * @param arg Instance of the FileProcessor, Results, Scheduler
	 * @return No return value.
	 */ 
	public WorkerThread(FileProcessor processor, FileDisplayInterface fileOut, IScheduler schedule) {
		Logger.writeMessage("DEBUG_VALUE=4 [WorkerThread's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
		fileProcessor = processor;
		result = fileOut;
		scheduler = schedule;
	}
	/**
	 * While the end of file has not been reached:
	 * Invoke a method in FileProcessor to read one line as a string,
	 * Run your algorithm to assign courses to this student,
	 * Store the results in the data structure in the Results instance. 
	 * @param arg No arguments.
	 * @return No return value.
	 */ 
    public void run() {
    	String line = null;
    	Logger.writeMessage("DEBUG_VALUE=3 [Thread " + Thread.currentThread().getName() + "'s run method called", 
    			Logger.DebugLevel.THREAD);
    	while((line = fileProcessor.readFile()) != null && !line.equals("")) {
    		IStudent student = scheduler.registerCourses(line);
    		result.storeResult(student);
    	} 
    }
}