package studentOrientation.activity;
import studentOrientation.util.Logger;
public class CostDollars extends Cost {
	
	public CostDollars() {
		Logger.writeMessage("DEBUG_VALUE=0 [CostDollars's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/* (non-Javadoc)
	 * @see studentOrientation.activity.Cost#getFormat()
	 */
	public String getFormat() { return "$"; }
	
	/* (non-Javadoc)
	 * @see studentOrientation.activity.Cost#getCost()
	 */
	public double getCost() { return getDefaultCost(); }
	
	/* (non-Javadoc)
	 * @see studentOrientation.activity.Cost#setCost(double)
	 */
	public void setCost(double value) { setDefaultCost(value); }
}