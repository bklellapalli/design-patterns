package studentOrientation.campusTour;
import studentOrientation.util.Logger;
public class CampusTourFactory {
	
	public static CampusTour createCampusTour(CampusTourOptions tourOption) {
		
		CampusTour campusTour = null;
		Logger.writeMessage("DEBUG_VALUE=1 [" + tourOption.name() + " Tour constructed]", 
				Logger.DebugLevel.ACTIVITY);
		
		switch (tourOption) {
		case BUSRIDE: campusTour = new BusRide();
			break;
		case ONFOOT: campusTour = new OnFoot();
			break;
		}
		return campusTour;
	}
}