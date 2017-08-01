package studentOrientation.activity;
import studentOrientation.util.Logger;
public class DurationMinutes extends Duration {
	
	public DurationMinutes() {
		Logger.writeMessage("DEBUG_VALUE=0 [DurationMinutes's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/* (non-Javadoc)
	 * @see studentOrientation.activity.Duration#getFormat()
	 */
	public String getFormat() { return "minutes"; }
	
	/* (non-Javadoc)
	 * @see studentOrientation.activity.Duration#getDuration()
	 */
	public double getDuration() { return getDefaultDurationt(); }
	
	/* (non-Javadoc)
	 * @see studentOrientation.activity.Duration#setDuration(double)
	 */
	public void setDuration(double span) { setDefaultDuration(span); }
}