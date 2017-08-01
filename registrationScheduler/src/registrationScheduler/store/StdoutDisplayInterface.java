package registrationScheduler.store;
import registrationScheduler.coursesRegistration.IStudent;
public interface StdoutDisplayInterface {
    void writeScheduleToScreen();
    void storeResult(IStudent student);
} 