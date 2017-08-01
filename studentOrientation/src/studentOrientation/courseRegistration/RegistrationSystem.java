package studentOrientation.courseRegistration;
import studentOrientation.util.Logger;
public class RegistrationSystem extends CourseRegistration {
	
	private double carbonFootprint = 10;
	private double duration = 10;
	private double efforts = 15;
	
	public RegistrationSystem() {
		Logger.writeMessage("DEBUG_VALUE=0 [RegistrationSystem's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/* (non-Javadoc)
	 * @see studentOrientation.courseRegistration.CourseRegistration#calculate()
	 */
	public void calculate() {
		costInstance.setCost(getDefaultcost());
		carbonFootprintInstance.setCarboonFootprint(carbonFootprint);
		durationInstance.setDuration(duration);
		effortsInstance.setEfforts(efforts);
	}
}