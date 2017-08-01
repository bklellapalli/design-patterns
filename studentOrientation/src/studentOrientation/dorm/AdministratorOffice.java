package studentOrientation.dorm;
import studentOrientation.util.Logger;
public class AdministratorOffice extends Dorm {
	
	private double carbonFootprint = 20;
	private double duration = 100;
	private double efforts = 150;

	public AdministratorOffice() {
		Logger.writeMessage("DEBUG_VALUE=0 [AdministratorOffice's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/* (non-Javadoc)
	 * @see studentOrientation.dorm.Dorm#calculate()
	 */
	public void calculate() {
		costInstance.setCost(getDefaultcost());
		carbonFootprintInstance.setCarboonFootprint(carbonFootprint);
		durationInstance.setDuration(duration);
		effortsInstance.setEfforts(efforts);
	}
}