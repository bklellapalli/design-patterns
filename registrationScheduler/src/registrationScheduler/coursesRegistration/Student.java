package registrationScheduler.coursesRegistration;
import java.util.HashMap;
import java.util.Map;
import registrationScheduler.util.Logger;
/**
 * class Student: Manage students, preference & allocation
 * @author Balakrishna
 */
public class Student implements IStudent {
	
	private String studentName;
	private Map<Integer, ICourse> preferenceList;
	private Map<Integer, ICourse> allocationList;
	
	/**
	 * Creates instance of Student
	 * @param arg student name
	 * @return No return value.
	 */
	public Student(String sName) {
		Logger.writeMessage("DEBUG_VALUE=4 [Student's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
		studentName = sName;
		preferenceList = new HashMap<Integer, ICourse>();
		allocationList = new HashMap<Integer, ICourse>();
	}
	
	/**
	 * Getter for student's name
	 * @param arg No arguments.
	 * @return String that stores Student's name.
	 */
	public String getStudentName() { return studentName; }
	
	/**
	 * Setter for student's name
	 * @param arg String of student's name.
	 * @return No return value.
	 */
	public void setStudentName(String sName) { studentName = sName; }
	
	/**
	 * Getter for preference list of student
	 * @param arg No arguments.
	 * @return Map that stores preference list of student
	 */
	public Map<Integer, ICourse> getPreferenceList() { return preferenceList; }
	
	/**
	 * Setter for preference list of student
	 * @param arg Map that stores preference list of student.
	 * @return No return value.
	 */
	public void setPreferenceList(Map<Integer, ICourse> preferences) { preferenceList = preferences; }
	
	/**
	 * Getter for allocation list of student
	 * @param arg No arguments.
	 * @return Map that stores allocation list of student
	 */
	public Map<Integer, ICourse> getAllocationList() { return allocationList; }
	
	/**
	 * Setter for allocation list of student
	 * @param arg Map that stores allocation list of student.
	 * @return No return value.
	 */
	public void setAllocationList(Map<Integer, ICourse> allocations) { allocationList = allocations; }

	@Override
	public String toString() { return super.toString(); }
}