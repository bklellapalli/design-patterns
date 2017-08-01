package studentOrientation.activity;
import studentOrientation.util.Logger;
public class EffortsCalories extends Efforts {
	
	public EffortsCalories() {
		Logger.writeMessage("DEBUG_VALUE=0 [EffortsCalories's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/* (non-Javadoc)
	 * @see studentOrientation.activity.Efforts#getFormat()
	 */
	public String getFormat() { return "calories"; }
	
	/* (non-Javadoc)
	 * @see studentOrientation.activity.Efforts#getEfforts()
	 */
	public double getEfforts() { return getDefaultEfforts(); }
	
	/* (non-Javadoc)
	 * @see studentOrientation.activity.Efforts#setEfforts(double)
	 */
	public void setEfforts(double work) { setDefaultEfforts(work); }
}