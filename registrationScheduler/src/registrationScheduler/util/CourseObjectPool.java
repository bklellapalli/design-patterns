package registrationScheduler.util;
import java.util.ArrayList;
import registrationScheduler.coursesRegistration.ICourse;
/**
 * class CourseObjectPool: Manage courses, check availability etc.
 * @author Balakrishna
 */
public class CourseObjectPool implements ObjectPool {
	
	private ArrayList<ICourse> courses =  null;
	private static ObjectPool objectPoolInstance = null;
	
	private CourseObjectPool() {
		Logger.writeMessage("DEBUG_VALUE=4 [CourseObjectPool constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
		courses = new ArrayList<ICourse>();	
	}
	
	/**
	 * A static method that creates instance of objectPool class
	 * @param arg No arguments.
	 * @return "singleton" Instance of CourseObjectPool class.
	 */ 
	public static ObjectPool getObjectPoolInstance() {
		if(objectPoolInstance == null) {
			synchronized(ObjectPool.class) {
				if(objectPoolInstance == null) {
					objectPoolInstance = new CourseObjectPool();
				}
			}
		}
		return objectPoolInstance;
	}

	/**
	 * Appends the specific course object to the end of courses list
	 * @param arg course object.
	 * @return No return value.
	 */ 
	public void addObject(ICourse course) {
		if(courses == null) {
			courses = new ArrayList<ICourse>();	
		}	
		courses.add(course);
	}

	/**
	 * Returns the course at the specified position in courses list.
	 * @param arg Index of course to return.
	 * @return Course at the specified position in this list.
	 */ 
	public ICourse borrowObject(int index) {
		return courses.get(index);
	}

	/**
	 * Returns total capacity of this course.
	 * @param arg course object.
	 * @return Total capacity of the course.
	 */ 
	public int getCapacity(ICourse course) {
		return course.getCapacity();
	}

	/**
	 * Returns available seats in this course.
	 * @param arg course object.
	 * @return Remaining capacity of the course.
	 */
	public int getAvailability(ICourse course) {
		return course.getAvailability();
	}
	
	/**
	 * Removes all of courses from the courses list.
	 * @param arg No arguments.
	 * @return No return value.
	 */
	public void clear() { courses.clear(); }

	/**
	 * Delete instance of CourseObjectPool
	 * @param arg No arguments.
	 * @return No return value.
	 */
	public void close() { objectPoolInstance = null; }
}