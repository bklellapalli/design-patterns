package studentOrientation.campusTour;
import studentOrientation.util.Logger;
public class BusRide extends CampusTour {

	private double defaultCost = 2;
	private double carbonFootprint = 50;
	private double duration = 120;
	private double efforts = 50;
	
	public BusRide() {
		Logger.writeMessage("DEBUG_VALUE=0 [BusRide's constructor called]", 
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