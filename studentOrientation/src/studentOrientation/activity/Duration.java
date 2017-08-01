package studentOrientation.activity;
public abstract class Duration {
	
	private double duration;
	
	/**
	 * Returns default value for duration
	 * @return duration
	 */
	protected double getDefaultDurationt() { return duration; }
	
	/**
	 * Sets default value for duration
	 * @param value duration
	 */
	protected void setDefaultDuration(double value) { duration = value; }
	
	/**
	 * Returns format for Time (Example: Minutes)
	 * @return duration
	 */
	public abstract String getFormat();
	
	/**
	 * Abstract method to return current duration
	 * @return duration
	 */
	public abstract double getDuration();
	
	/**
	 * Abstract method to set current value for duration
	 * @param span
	 */
	public abstract void setDuration(double span);
}