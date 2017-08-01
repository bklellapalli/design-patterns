package registrationScheduler.util;
import registrationScheduler.coursesRegistration.ICourse;

public interface ObjectPool {
	void addObject(ICourse course);
	ICourse borrowObject(int index);
	int getCapacity(ICourse course);
	int getAvailability(ICourse course);
	void clear();
	void close();
}