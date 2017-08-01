package studentOrientation.bookStore;
import studentOrientation.util.Logger;
public class UniversityBookStore extends BookStore {
	
	private double carbonFootprint = 10;
	private double duration = 125;
	private double efforts = 25;
	
	public UniversityBookStore() {
		Logger.writeMessage("DEBUG_VALUE=0 [UniversityBookStore's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/* (non-Javadoc)
	 * @see studentOrientation.bookStore.BookStore#calculate()
	 */
	public void calculate() {	
		costInstance.setCost(getDefaultcost());
		carbonFootprintInstance.setCarboonFootprint(carbonFootprint);
		durationInstance.setDuration(duration);
		effortsInstance.setEfforts(efforts);
	}
}