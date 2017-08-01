package studentOrientation.dorm;
import studentOrientation.Store.StdoutDisplayInterface;
import studentOrientation.activity.CarbonFootprint;
import studentOrientation.activity.CarbonFootprintCO2;
import studentOrientation.activity.Cost;
import studentOrientation.activity.CostDollars;
import studentOrientation.activity.Duration;
import studentOrientation.activity.DurationMinutes;
import studentOrientation.activity.Efforts;
import studentOrientation.activity.EffortsCalories;
import studentOrientation.util.Logger;
public abstract class Dorm {
	
	protected CarbonFootprint carbonFootprintInstance;
	protected Cost costInstance;
	protected Duration durationInstance;
	protected Efforts effortsInstance;
	private double defaultCost = 20000;

	public Dorm() {
		carbonFootprintInstance = new CarbonFootprintCO2();
		costInstance = new CostDollars();
		durationInstance = new DurationMinutes();
		effortsInstance = new EffortsCalories();
	}
	
	/**
	 * Returns default value of cost for for course registration
	 * @return cost
	 */
	protected double getDefaultcost() {	return defaultCost; }
	
	/**
	 * Store cost, duration, carbon footprint and efforts in result class 
	 * @param arg StdoutDisplayInterface result
	 */
	public void addResult(StdoutDisplayInterface result) {
		
		Logger.writeMessage("DEBUG_VALUE=2 [" + this.getClass().getSimpleName() + " STORED]", 
				Logger.DebugLevel.STORE);
		
		result.setTotalCost(result.getTotalCost() + costInstance.getCost());
		result.setTotalCarbonFootPrint(result.getTotalCarbonFootPrint() + carbonFootprintInstance.getCarboonFootprint());
		result.setTotalDuration(result.getTotalDuration() + durationInstance.getDuration());
		result.setTotalEfforts(result.getTotalEfforts() + effortsInstance.getEfforts());
	}
	
	/**
	 * Abstract method to calculate cost, carbon footprint,
	 * efforts, duration 
	 */
	public abstract void calculate();
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() +" [Cost = " + costInstance.getFormat() + costInstance.getCost()+
				", Carbon Footprint = " + carbonFootprintInstance.getCarboonFootprint() + carbonFootprintInstance.getFormat() + 
				", Duration = " + durationInstance.getDuration() + durationInstance.getFormat() +
				", Efforts = " + effortsInstance.getEfforts() + effortsInstance.getFormat() + "]";
	}	
}