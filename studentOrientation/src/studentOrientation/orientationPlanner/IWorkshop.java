package studentOrientation.orientationPlanner;
public interface IWorkshop {
	
	/**
	 * Constructs orientation checklist consists of taking 
	 * a campus tour, buying books, selecting a dorm, and 
	 * registering for courses.
	 * @param arg IStudentOrientationPlanner
	 */
	void construct(IStudentOrientationPlanner orientationPlanner);
}