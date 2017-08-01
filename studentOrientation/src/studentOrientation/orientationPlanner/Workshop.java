package studentOrientation.orientationPlanner;
import studentOrientation.util.Logger;
public class Workshop implements IWorkshop {

	/**
	 * Constructs orientation checklist - campus tour,
	 * buying books, selecting a Dorm, and course registration
	 */
	public Workshop() {
		Logger.writeMessage("DEBUG_VALUE=0 [Workshop's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/* (non-Javadoc)
	 * @see studentOrientation.orientationPlanner.IWorkshop#construct(
	 * studentOrientation.orientationPlanner.IStudentOrientationPlanner)
	 */
	public void construct(IStudentOrientationPlanner orientationPlanner) {
		orientationPlanner.takeCampusTour();
		orientationPlanner.buyBooks();
		orientationPlanner.selectDorm();
		orientationPlanner.registerCourses();
	}
}