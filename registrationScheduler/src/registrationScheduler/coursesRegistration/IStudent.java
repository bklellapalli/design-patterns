package registrationScheduler.coursesRegistration;
import java.util.Map;
public interface IStudent {
	String getStudentName();
	void setStudentName(String sName);
	Map<Integer, ICourse> getPreferenceList();
	void setPreferenceList(Map<Integer, ICourse> preferences);
	Map<Integer, ICourse> getAllocationList();
	void setAllocationList(Map<Integer,ICourse> allocations);
}