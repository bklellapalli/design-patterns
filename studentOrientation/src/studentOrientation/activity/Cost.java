package studentOrientation.activity;
public abstract class Cost {
	
	private double cost;	
	
	/**
	 * Returns default value for cost
	 * @return cost
	 */
	protected double getDefaultCost() {	return cost; }
	
	/**
	 * Sets default value for cost as value sent
	 * @param value default value for cost
	 */
	protected void setDefaultCost(double value) { cost = value; }
	
	/**
	 * Returns format for currency
	 * @return Cost in Dollars etc
	 */
	public abstract String getFormat();
	
	/**
	 * Returns current value for cost
	 * @return cost
	 */
	public abstract double getCost();
	
	/**
	 * Sets current value for cost as value sent
	 * @param value current cost
	 */
	public abstract void setCost(double value);
}