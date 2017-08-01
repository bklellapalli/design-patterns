package studentOrientation.courseRegistration;
import studentOrientation.util.Logger;
public class RegistrarOffice extends CourseRegistration {
	
	private double defaultPercent = 0.03;
	private double carbonFootprint = 20;
	private double duration = 50;
	private double efforts = 80;
	
	public RegistrarOffice() {
		Logger.writeMessage("DEBUG_VALUE=0 [RegistrarOffice's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/* (non-Javadoc)
	 * @see studentOrientation.courseRegistration.CourseRegistration#calculate()
	 */
	public void calculate() {	
		costInstance.setCost(getDefaultcost() - defaultPercent * getDefaultcost());
		carbonFootprintInstance.setCarboonFootprint(carbonFootprint);
		durationInstance.setDuration(duration);
		effortsInstance.setEfforts(efforts);
	}
}