package studentOrientation.Store;
public interface StdoutDisplayInterface {	
	
	/**
	 * Return total cost of all Activity
	 * @return Total Cost (double value)
	 */
	double getTotalCost();
	
	/**
	 * Set total cost of all Activity
	 * @param arg Cost (double value)
	 */
	void setTotalCost(double totalCost);
	
	/**
	 * Return total carbon footprint of all Activity
	 * @return total Carbon FootPrint (double value)
	 */
	double getTotalCarbonFootPrint() ;
	
	/**
	 * Set total carbon footprint of all Activity
     * @param arg total Carbon FootPrint (double value)
	 */
	void setTotalCarbonFootPrint(double totalCarbonFootPrintIn) ;
	
	/**
	 * Return total duration of all Activity
	 * @return total duration (double value)
	 */
	double getTotalDuration();
	
	/**
	 * Set total duration of all Activity
     * @param arg total duration (double value)
	 */
	void setTotalDuration(double totalDurationIn);
	
	/**
	 * Return total  Efforts of all Activity
	 * @return total Efforts (double value)
	 */
	double getTotalEfforts() ;
	
	/**
	 * Set total  Efforts  of all Activity
     * @param arg total Efforts (double value)
	 */
	void setTotalEfforts(double totalEffortsIn);
}