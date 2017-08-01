package studentOrientation.activity;
import studentOrientation.util.Logger;
public class CarbonFootprintCO2 extends CarbonFootprint {
	
	public CarbonFootprintCO2() {
		Logger.writeMessage("DEBUG_VALUE=0 [CarbonFootprintCO2's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/* (non-Javadoc)
	 * @see studentOrientation.activity.CarbonFootprint#getFormat()
	 */
	public String getFormat() { return "CO2"; }
	
	/* (non-Javadoc)
	 * @see studentOrientation.activity.CarbonFootprint#getCarboonFootprint()
	 */
	public double getCarboonFootprint() { return getDefaultFootprint(); }
	
	/* (non-Javadoc)
	 * @see studentOrientation.activity.CarbonFootprint#setCarboonFootprint(double)
	 */
	public void setCarboonFootprint(double tons) { setDefaultFootprint(tons); }
}