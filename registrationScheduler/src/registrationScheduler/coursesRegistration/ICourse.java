package registrationScheduler.coursesRegistration;
public interface ICourse {
	String getCourseName();
	void setCourseName(String cName);
	int getCapacity();
	void setCapacity(int max);
	int getAvailability();
	void setAvailability(int max);
	boolean allocateCourse();
}