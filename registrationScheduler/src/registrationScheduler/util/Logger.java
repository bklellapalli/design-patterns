package registrationScheduler.util;
/**
 * class Logger: Writes message to stdout depending on DEBUG_VALUE.
 * @author Balakrishna
 */
public class Logger{
 
    private static DebugLevel debugLevel;
    public static enum DebugLevel { NOOUT, STORE, RESULTS, THREAD, CONSTRUCTOR };
    
	/**
	 * Sets DEBUG_VALUE
	 * @param arg DEBUG_VALUE, that controls what has to be printed.
	 * @return No return value.
	 */
    public static void setDebugValue (int levelIn) {
    	switch (levelIn) {
    		case 0: debugLevel = DebugLevel.NOOUT; break;
    		case 1: debugLevel = DebugLevel.STORE; break;
    		case 2: debugLevel = DebugLevel.RESULTS; break;
    		case 3: debugLevel = DebugLevel.THREAD; break;
	  		case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
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

    public String toString() { 
    	return "Debug Level is " + debugLevel; 
    	}
}