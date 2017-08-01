package studentOrientation.orientationPlanner;
public interface IStudentOrientationPlanner {
	
	/**
	 * Construct campus tour by calculating
	 * total cost, duration, efforts and carbon footprint 
	 */
	void takeCampusTour();
	
	/**
	 * Construct Book store activity by calculating
	 * total cost, duration, efforts and carbon footprint 
	 */
	void buyBooks();
	
	/**
	 * Construct Dorm activity by calculating
	 * total cost, duration, efforts and carbon footprint 
	 */
	void selectDorm();
	
	/**
	 * Construct course registration activity by
	 * calculating cost, duration, efforts and carbon footprint
	 */
	void registerCourses();
}