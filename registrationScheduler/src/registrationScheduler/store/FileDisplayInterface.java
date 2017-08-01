package registrationScheduler.store;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.coursesRegistration.IStudent;
public interface FileDisplayInterface {
	void writeSchedulesToFile(FileProcessor processor);
    void storeResult(IStudent student);
}