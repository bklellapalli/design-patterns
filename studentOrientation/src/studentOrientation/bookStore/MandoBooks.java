package studentOrientation.bookStore;
import studentOrientation.util.Logger;
public class MandoBooks extends BookStore {
	
	private double defaultPercent = 0.05;
	private double carbonFootprint = 10;
	private double duration = 200;
	private double efforts = 50;
	
	public MandoBooks() {
		Logger.writeMessage("DEBUG_VALUE=0 [MandoBooks's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/* (non-Javadoc)
	 * @see studentOrientation.bookStore.BookStore#calculate()
	 */
	public void calculate() {	
		costInstance.setCost(getDefaultcost() + defaultPercent * getDefaultcost());
		carbonFootprintInstance.setCarboonFootprint(carbonFootprint);
		durationInstance.setDuration(duration);
		effortsInstance.setEfforts(efforts);
	}
}