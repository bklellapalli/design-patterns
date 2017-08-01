package registrationScheduler.coursesRegistration;
import registrationScheduler.util.Logger;
/**
 * class Course: Allocate course, capacity & availability of courses.
 * @author Balakrishna
 */
public class Course implements ICourse {
	
	private String courseName;
	private int capacity;
	private int availability;
	
	/**
	 * Set course name and capacity
	 * @param arg student name
	 * @return No return value.
	 */
	public Course(String cName, int max) {
		Logger.writeMessage("DEBUG_VALUE=4 [Course's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
		courseName = cName;
		capacity = max;
		availability = max;
	}	
	
	/**
	 * Getter for Course's name
	 * @param arg No arguments.
	 * @return String that stores Course's name.
	 */
	public String getCourseName() {	return courseName; }
	
	/**
	 * Setter for Course's name
	 * @param arg String of Course's name.
	 * @return No return value.
	 */
	public void setCourseName(String cName) { courseName = cName; }
	
	/**
	 * Getter for Course's capacity
	 * @param arg No arguments.
	 * @return Integer that stores Course's total capacity.
	 */
	public int getCapacity() { return capacity; }
	
	/**
	 * Getter for Course's current availability.
	 * @param arg No arguments.
	 * @return Integer that stores Course's availability.
	 */
	public int getAvailability() { return availability; }
	
	/**
	 * Setter for Course's capacity
	 * @param arg Integer of Course's max capacity.
	 * @return No return value.
	 */
	public void setCapacity(int max) { capacity = max; }
	
	/**
	 * Setter for Course's availability
	 * @param arg Integer of Course's availability.
	 * @return No return value.
	 */
	public void setAvailability(int max) { availability = max; }
	
	/**
	 * Allocate course if it is not full
	 * @param arg No arguments.
	 * @return true if course allocated else return false.
	 */
	public boolean allocateCourse(){	
		if(availability > 0) {	--availability;
			return true;
		}
		return false;
	}
	@Override
	public String toString() { return super.toString(); }
}