package studentOrientation.orientationPlanner;
import studentOrientation.Store.Results;
import studentOrientation.Store.StdoutDisplayInterface;
import studentOrientation.bookStore.BookStore;
import studentOrientation.bookStore.BookStoreFactory;
import studentOrientation.bookStore.BookStoreOptions;
import studentOrientation.campusTour.CampusTour;
import studentOrientation.campusTour.CampusTourFactory;
import studentOrientation.campusTour.CampusTourOptions;
import studentOrientation.courseRegistration.CourseRegistration;
import studentOrientation.courseRegistration.CourseRegistrationFactory;
import studentOrientation.courseRegistration.CourseRegistrationOptions;
import studentOrientation.dorm.Dorm;
import studentOrientation.dorm.DormFactory;
import studentOrientation.dorm.DormOptions;
import studentOrientation.util.Logger;
public class StudentOrientationPlanner implements IStudentOrientationPlanner {

	private BookStore bookStore;
	private CampusTour campusTour;
	private CourseRegistration courseRegistration;
	private Dorm dorm;
	private StdoutDisplayInterface result;
	
	/**
	 * Constructs orientation checklist consists of taking 
	 * a campus tour, buying books, selecting a dorm, and 
	 * registering for courses.
	 * @param arg  Options - book store, tour, dorm, course registration .
	 */
	public StudentOrientationPlanner(BookStoreOptions bookStoreOption, CampusTourOptions campusTourOptions, 
			DormOptions dormOptions, CourseRegistrationOptions courseRegistrationOptions) {	
		try {
			Logger.writeMessage("DEBUG_VALUE=0 [StudentOrientationPlanner's constructor called]", 
					Logger.DebugLevel.CONSTRUCTOR);
			
			bookStore = BookStoreFactory.createBookStore(bookStoreOption);
			campusTour = CampusTourFactory.createCampusTour(campusTourOptions);
			dorm = DormFactory.createDorm(dormOptions);
			courseRegistration = CourseRegistrationFactory.createCourseRegistration(courseRegistrationOptions);
			result = new Results();
		}
		catch (NullPointerException ex) {
			System.out.println("Invalid option passed.");
			System.exit(0);
		}	
	}

	/* (non-Javadoc)
	 * @see IStudentOrientationPlanner#takeCampusTour()
	 */
	public void takeCampusTour() { 
		campusTour.calculate();	
		campusTour.addResult(result);
	}
	
	/* (non-Javadoc)
	 * @see IStudentOrientationPlanner#buyBooks()
	 */
	public void buyBooks() { 
		bookStore.calculate();
		bookStore.addResult(result);
	}
	
	/* (non-Javadoc)
	 * @see IStudentOrientationPlanner#selectDorm()
	 */
	public void selectDorm() { 
		dorm.calculate(); 
		dorm.addResult(result);
	}
	
	/* (non-Javadoc)
	 * @see IStudentOrientationPlanner#registerCourses()
	 */
	public void registerCourses() {	
		courseRegistration.calculate();	
		courseRegistration.addResult(result);
	}
	
	@Override
	public String toString() {
		return "\n______ StudentOrientationPlanner ______  \nBookStore : " + bookStore
				+ "\nCampusTour : " + campusTour + "\nCourse : "
				+ courseRegistration + "\nDorm : " + dorm + "\n\n" + result.toString();
	}
}