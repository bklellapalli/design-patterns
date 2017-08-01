package studentOrientation.dorm;
import studentOrientation.util.Logger;
public class DormFactory {
	
	public static Dorm createDorm(DormOptions dormOption) {
		
		Dorm dorm = null;
		Logger.writeMessage("DEBUG_VALUE=1 [" + dormOption.name() + " Dorm constructed]", 
				Logger.DebugLevel.ACTIVITY);
		
		switch (dormOption) {
			case QUEUE: dorm = new AdministratorOffice();
				break;
			case ONLINE: dorm = new OnlineContext();
				break;
		}
		return dorm;
	}
}