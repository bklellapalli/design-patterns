package registrationScheduler.coursesRegistration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import registrationScheduler.util.CourseObjectPool;
import registrationScheduler.util.Logger;
import registrationScheduler.util.ObjectPool;
/**
 * class Scheduler: Responsible for scheduling courses to all students
 * @author Balakrishna
 */
public class Scheduler implements IScheduler {

	private ArrayList<IStudent> students = null;
	private ObjectPool objectPool = null;

	// Set preference of each student by reading preferences from file.		
	private void setPrefernce(IStudent student, String[] token) {
		for(int index = 1; index < token.length; index++) {
			try {
				student.getPreferenceList().put(Integer.parseInt(token[index]), objectPool.borrowObject(index-1));
			}
			catch(NumberFormatException ex) {
				System.err.println("Student's preference has to be a number.");
				ex.printStackTrace();
				System.exit(0);
			}
		}
	}
	
	// Get random student to whom 5 preference have been allocated.
	private IStudent getRandomStudent() {
		return students.get(new Random().nextInt(students.size()));
	}
	
	// Check if allocation has been completed for minimum no of courses.
	private boolean isAllocationCompleted(IStudent student) {
		return student.getAllocationList().size() == Default.REQ_COURSES.value();
	}
	
	// Select random student and change his/her allocation
	private void changeCourseSelection(IStudent student) {
		IStudent rStudent = getRandomStudent();
		if(isAllocationCompleted(rStudent) && 
				Collections.max(rStudent.getAllocationList().keySet()) < Default.COURSES.value()) {
				int key = Collections.max(rStudent.getAllocationList().keySet());
				for(; key > 1; key--) {
					if(!student.getAllocationList().containsKey(key) && 
							rStudent.getAllocationList().containsKey(key)) break;
				}
				student.getAllocationList().put(key, rStudent.getAllocationList().get(key));
				rStudent.getAllocationList().remove(key);	
				assignCourses(rStudent);
		}
	}
	
	// Allocate courses to each students
	private void assignCourses(IStudent student) {
		for(int key = 1; key <= Default.COURSES.value(); key++) {
			ICourse course = student.getPreferenceList().get(key);
			if(objectPool.getAvailability(course) > 0 && !student.getAllocationList().containsKey(key)) {
				course.allocateCourse();
				student.getAllocationList().put(key, course);
			}
			if(isAllocationCompleted(student)) return;
		}
		while(!isAllocationCompleted(student)) 
			changeCourseSelection(student);
	}
	
	public enum Default { 
		COURSES(7), CAPACITY(60), STUDENTS(80), REQ_COURSES(5);
		private int value;
		Default(int val) { value = val; }
		int value() { return value; }
	}
	
	/**
	 * Create Course and assign max capacity using object pool.
	 * @param arg No arguments.
	 * @return No return value.
	 */
	public Scheduler() {
		Logger.writeMessage("DEBUG_VALUE=4 [Scheduler's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
		students = new ArrayList<IStudent>();
		objectPool = CourseObjectPool.getObjectPoolInstance();
		objectPool.addObject(new Course("A", Default.CAPACITY.value()));
		objectPool.addObject(new Course("B", Default.CAPACITY.value()));
		objectPool.addObject(new Course("C", Default.CAPACITY.value()));
		objectPool.addObject(new Course("D", Default.CAPACITY.value()));
		objectPool.addObject(new Course("E", Default.CAPACITY.value()));
		objectPool.addObject(new Course("F", Default.CAPACITY.value()));
		objectPool.addObject(new Course("G", Default.CAPACITY.value()));
	}

	/**
	 * Record preference list of students and allocate courses
	 * @param arg String containing preference of each student.
	 * @return Instance of Student.
	 */
	public synchronized IStudent registerCourses(String line) {		
		String[] token = line.split("\\s+");
		IStudent student = new Student(token[0]);
		setPrefernce(student, token);
		assignCourses(student);
		students.add(student);
		return student;
	}
	
	@Override
	public String toString() { return super.toString(); }
}