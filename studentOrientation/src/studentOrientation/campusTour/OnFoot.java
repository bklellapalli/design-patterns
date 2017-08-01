package studentOrientation.campusTour;
import studentOrientation.util.Logger;
public class OnFoot extends CampusTour {
	
	private double defaultCost = 0.10;
	private double carbonFootprint = 0;
	private double duration = 240;
	private double efforts = 100;
	
	public OnFoot() {
		Logger.writeMessage("DEBUG_VALUE=0 [OnFoot's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/* (non-Javadoc)
	 * @see studentOrientation.campusTour.CampusTour#calculate()
	 */
	public void calculate() {
		costInstance.setCost(defaultCost);
		carbonFootprintInstance.setCarboonFootprint(carbonFootprint);
		durationInstance.setDuration(duration);
		effortsInstance.setEfforts(efforts);
	}
}