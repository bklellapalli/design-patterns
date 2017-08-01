package studentOrientation.activity;
public abstract class CarbonFootprint {
	
	private double carboonFootprint;	
	
	/**
	 * Returns default value for carbon footprint
	 * @return carboonFootprint
	 */
	protected double getDefaultFootprint() { return carboonFootprint; }
	
	/**
	 * Sets default value for carbon footprint
	 * @param value carbon footprint
	 */
	protected void setDefaultFootprint(double value) { carboonFootprint = value; }
	
	/**
	 * Returns format for measuring Carbon footprint
	 * @return carboonFootprint in CO2 etc
	 */
	public abstract String getFormat();
	
	/**
	 * Abstract method to return current value for carbon footprint
	 * @return carbon footprint
	 */
	public abstract double getCarboonFootprint();
	
	/**
	 * Abstract method to set current value for carbon footprint
	 * @param tons carbon footprint
	 */
	public abstract void setCarboonFootprint(double tons);
}