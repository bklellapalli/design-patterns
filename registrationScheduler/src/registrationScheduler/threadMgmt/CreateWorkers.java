package registrationScheduler.threadMgmt;
import registrationScheduler.coursesRegistration.IScheduler;
import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
/**
 * class CreateWorkers: Allocate thread & cause threads to execute
 * @author Balakrishna
 */
public class CreateWorkers  {
	
	private FileProcessor fileProcessor = null;
	private FileDisplayInterface result = null;
	private IScheduler scheduler = null;
	
	/**
	 * Allocates a new CreateWorkers object
	 * @param arg Instance of the FileProcessor, Results, Scheduler
	 * @return No return value.
	 */ 
	public CreateWorkers(FileProcessor processor, FileDisplayInterface fileOut, IScheduler schedule) {
		Logger.writeMessage("DEBUG_VALUE=4 [CreateWorkers's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
		fileProcessor = processor;
		result = fileOut;
		scheduler = schedule;
	}
	
	
	/**
	 * Create <NUM_THREADS> threads, start them and join on them.
	 * @param arg NUM_THREADS, Number of threads to create
	 * @return No return value.
	 */ 
	public void startWorkers(int threadCount) throws InterruptedException {
		Thread[] threads = new Thread[threadCount];
		for(int i = 0; i < threadCount; i++) {
			threads[i] = new Thread(new WorkerThread(fileProcessor, result, scheduler));
			threads[i].start();
		}
		for(int i = 0; i < threadCount; i++) {
			threads[i].join();
		}
	}
}