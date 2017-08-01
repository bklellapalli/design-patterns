package studentOrientation.util;
public class Logger {
	private static DebugLevel debugLevel;
    public static enum DebugLevel { CONSTRUCTOR, ACTIVITY, STORE};
    
    public Logger() {
    	Logger.writeMessage("DEBUG_VALUE=0 [Logger's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
    }
       
    /**
	 * Sets DEBUG_VALUE
	 * @param arg DEBUG_VALUE, that controls what has to be printed.
	 */
    public static void setDebugValue (int levelIn) {
    	switch (levelIn) {
  			case 0: debugLevel = DebugLevel.CONSTRUCTOR; break;
    		case 1: debugLevel = DebugLevel.ACTIVITY; break;
    		case 2: debugLevel = DebugLevel.STORE; break;
		}
    }
   
    /**
	 * Compare DEBUG_VALUE and prints message and then terminate.
	 * @param arg DEBUG_VALUE and String to be printed.
	 */
    public static void writeMessage (String message, DebugLevel levelIn ) {
    	if (levelIn == debugLevel) 
    		System.out.println(message);
    }

    public String toString() { 
    	return "Debug Level is " + debugLevel; 
    }
}