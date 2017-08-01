package wordCount.util;

public class Logger {
	
	private static DebugLevel debugLevel;
    public static enum DebugLevel { CONSTRUCTOR };
    
    /**
	 * Sets DEBUG_VALUE
	 * @param arg DEBUG_VALUE, that controls what has to be printed.
	 * @return No return value.
	 */
    public static void setDebugValue (int levelIn) {
    	switch (levelIn) {
	  		case 0: debugLevel = DebugLevel.CONSTRUCTOR; break;
		}
    }
    
    /**
	 * Sets DEBUG_VALUE
	 * @param arg DEBUG_VALUE, that controls what has to be printed.
	 * @return No return value.
	 */
    public static void setDebugValue (DebugLevel levelIn) {
    	debugLevel = levelIn;
    }
    
    /**
	 * Compare DEBUG_VALUE and prints message and then terminate.
	 * @param arg DEBUG_VALUE and String to be printed.
	 * @return No return value.
	 */
    public static void writeMessage (String message, DebugLevel levelIn ) {
    	if (levelIn == debugLevel) System.out.println(message);
    }
    
    @Override
    public String toString() { 
    	return "Debug Level is " + debugLevel; 
    }
}