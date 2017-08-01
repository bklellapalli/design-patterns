package studentOrientation.Store;
import studentOrientation.util.Logger;
public class Results implements StdoutDisplayInterface {

	private double totalCost, totalCarbonFootPrint, totalDuration, totalEfforts;

	public Results() {
		Logger.writeMessage("DEBUG_VALUE=0 [Results's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/* (non-Javadoc)
	 * @see StdoutDisplayInterface.getTotalCarbonFootPrint()
	 */
	public double getTotalCarbonFootPrint() { return totalCarbonFootPrint; }

	/* (non-Javadoc)
	 * @see StdoutDisplayInterface.setTotalCarbonFootPrint(double totalCarbonFootPrintIn)
	 */
	public void setTotalCarbonFootPrint(double totalCarbonFootPrintIn) { totalCarbonFootPrint = totalCarbonFootPrintIn; }

	/* (non-Javadoc)
	 * @see StdoutDisplayInterface.getTotalDuration()
	 */
	public double getTotalDuration() { return totalDuration; }

	/* (non-Javadoc)
	 * @see StdoutDisplayInterface.setTotalDuration(double totalDurationIn)
	 */
	public void setTotalDuration(double totalDurationIn) { totalDuration = totalDurationIn; }

	/* (non-Javadoc)
	 * @see StdoutDisplayInterface.getTotalEfforts()
	 */
	public double getTotalEfforts() { return totalEfforts; }

	/* (non-Javadoc)
	 * @see StdoutDisplayInterface.setTotalEfforts(double totalEffortsIn)
	 */
	public void setTotalEfforts(double totalEffortsIn) { totalEfforts = totalEffortsIn; }
	
	/* (non-Javadoc)
	 * @see StdoutDisplayInterface.getTotalCost()
	 */
	public double getTotalCost() {	return totalCost; }
	
	/* (non-Javadoc)
	 * @see StdoutDisplayInterface.setTotalCost(double totalCostIn)
	 */
	public void setTotalCost(double totalCostIn) { totalCost = totalCostIn;}

	@Override
	public String toString() {
		return "Total Cost = " + totalCost + ", Total CarbonFootPrint = " + totalCarbonFootPrint + 
				", Total Duration = "+ totalDuration + ", Total Efforts = " + totalEfforts;
	}
}