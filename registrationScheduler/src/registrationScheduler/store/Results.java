package registrationScheduler.store;
import java.util.Map.Entry;
import java.util.Vector;
import registrationScheduler.coursesRegistration.Course;
import registrationScheduler.coursesRegistration.ICourse;
import registrationScheduler.coursesRegistration.IStudent;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
/**
 * class Results: Program to print course allocation results
 * @author Balakrishna
 */
public class Results implements StdoutDisplayInterface, FileDisplayInterface {

	private Vector<IStudent> results = null;
	private double averagePreferenceScore = 0;

	// Append Schedules and total average preference for all students
	private String getResultDetails() {
		double totalScore = 0;
		StringBuilder summary = new StringBuilder();
		for(IStudent student : results) {
			int prefScore = 0;
			summary.append(student.getStudentName() + " ");	
			for(Entry<Integer, ICourse> entry: student.getAllocationList().entrySet()) {
				summary.append(((Course) entry.getValue()).getCourseName() + " ");
				prefScore += entry.getKey();
			}
			totalScore += prefScore;
			summary.append(prefScore + "\n");
		}
		averagePreferenceScore = totalScore/results.size();
		summary.append("\nAverage preference_score is: " + totalScore/results.size());
		return summary.toString();
	}

	/**
	 * Allocates a new Results object
	 * @param arg No arguments.
	 * @return No return value.
	 */ 
	public Results() {
		Logger.writeMessage("DEBUG_VALUE=4 [Results's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
		results = new Vector<IStudent>();
	}
	
	/**
	 * Store the results in the results vector in the Results instance.
	 * @param arg student object.
	 * @return No return value.
	 */ 
	public void storeResult(IStudent student) {
		Logger.writeMessage("DEBUG_VALUE=2 [Entry added to result data]", 
				Logger.DebugLevel.RESULTS);
		results.addElement(student);
	}

	/**
	 * Print schedules, average preference score for all the students.
	 * @param arg No arguments.
	 * @return No return value.
	 */ 
	public void writeScheduleToScreen() {
		Logger.writeMessage("DEBUG_VALUE=1\n" + getResultDetails(), Logger.DebugLevel.STORE); 
		Logger.writeMessage("DEBUG_VALUE=0 [Average preference_score is: " + averagePreferenceScore + "]", 
				Logger.DebugLevel.NOOUT); 
	}
	
	/**
	 * Print the schedules, average score for all the students to file.
	 * @param arg Instance of FileProcessor.
	 * @return No return value.
	 */ 
	public void writeSchedulesToFile(FileProcessor processor) {
		processor.writeFile(getResultDetails());
	}
}