package studentOrientation.courseRegistration;
import studentOrientation.util.Logger;
public class CourseRegistrationFactory {
	
	public static CourseRegistration createCourseRegistration(CourseRegistrationOptions courseOption) {
		
		CourseRegistration courseRegistration = null;	
		Logger.writeMessage("DEBUG_VALUE=1 [" + courseOption.name() + " Course constructed]", 
				Logger.DebugLevel.ACTIVITY);
		
		switch (courseOption) {
			case SUBMITFORM: courseRegistration = new RegistrarOffice();
				break;
			case REGISTRATIONSYSTEM: courseRegistration = new RegistrationSystem();
				break;
		}
		return courseRegistration;
	}
}