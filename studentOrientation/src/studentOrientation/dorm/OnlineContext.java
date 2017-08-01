package studentOrientation.dorm;
import studentOrientation.util.Logger;
public class OnlineContext extends Dorm {
	
	private double defaultPercent = 0.02;
	private double carbonFootprint = 10;
	private double duration = 30;
	private double efforts = 50;

	public OnlineContext() {
		Logger.writeMessage("DEBUG_VALUE=0 [OnlineContext's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/* (non-Javadoc)
	 * @see studentOrientation.dorm.Dorm#calculate()
	 */
	public void calculate() {
		costInstance.setCost(getDefaultcost() + defaultPercent * getDefaultcost());
		carbonFootprintInstance.setCarboonFootprint(carbonFootprint);
		durationInstance.setDuration(duration);
		effortsInstance.setEfforts(efforts);
	}
}