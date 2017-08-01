package studentOrientation.activity;
public abstract class Efforts {
	
	private double efforts;
	
	/**
	 * Returns default value for efforts
	 * @return efforts
	 */
	protected double getDefaultEfforts() {	return efforts; }
	
	/**
	 * Sets default value for efforts
	 * @param value efforts
	 */
	protected void setDefaultEfforts(double value) { efforts = value; }
	
	/**
	 * Abstract method to return format for efforts
	 * @param work format in calories
	 */
	public abstract String getFormat();
	
	/**
	 * Abstract method to return current value of efforts
	 * @return efforts
	 */
	public abstract double getEfforts();
	
	/**
	 * Abstract method to set current value for efforts
	 * @param work efforts
	 */
	public abstract void setEfforts(double work);
}