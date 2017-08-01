package studentOrientation.driver;
import studentOrientation.bookStore.BookStoreOptions;
import studentOrientation.campusTour.CampusTourOptions;
import studentOrientation.courseRegistration.CourseRegistrationOptions;
import studentOrientation.dorm.DormOptions;
import studentOrientation.orientationPlanner.IStudentOrientationPlanner;
import studentOrientation.orientationPlanner.IWorkshop;
import studentOrientation.orientationPlanner.StudentOrientationPlanner;
import studentOrientation.orientationPlanner.Workshop;
import studentOrientation.util.Logger;
public class Driver {

	/**
	   * Develop a tool for student orientation program at Binghamton University. 
	   * @param arg Optional argument for Debug value.
	   * @exception NumberFormatException
	   */ 
	public static void main(String[] args) {	
		
		try {
			// Accept 1 or no argument
			if(args.length > 1) {
				System.err.println("Incorrect Format:\n"
						+ "Option 1: java Driver \nOption 2: java Driver <DEBUG_VALUE>");
				System.exit(0);
			}
			
			// Check if Debug value is passed from command line
			if(args.length == 1) {
				if (Integer.valueOf(args[0]) < 0 || Integer.valueOf(args[0]) > 2) {
					System.err.println("<DEBUG_VALUE> has to be between 0 and 2.");
					System.exit(0);
				}
				// Set Debug value
				Logger.setDebugValue(Integer.valueOf(args[0]));
			}
			IStudentOrientationPlanner orientationPlanner = new StudentOrientationPlanner(
					BookStoreOptions.MANDO, CampusTourOptions.BUSRIDE, DormOptions.ONLINE, 
						CourseRegistrationOptions.REGISTRATIONSYSTEM); 
			
			// Construct Orientation plan
			IWorkshop workshop = new Workshop();
			workshop.construct(orientationPlanner);
			System.out.println(orientationPlanner.toString());
		} 
		catch(NumberFormatException ex) {
			System.err.println("<DEBUG_VALUE> has to be between 0 and 2.");
			System.exit(0);
		}	
	}
}