# Registration Scheduler

PURPOSE:
Application of design principles for a simple multi-threaded application that assign courses to students based on their preferences. 

DATA STRUCTURE:
Vector for storing results of allocated courses.
I have used Vector over ArrayList to store result because vectors are synchronized. Any method that accesses the vector is thread safe.
Also, It can be accessed using index. Vector can grow depending upon the number of students.
Arraylist grows by 50% of its previous size and vector grows by 100% of previous size. This reduces the amount of incremental reallocation. 

Time Complexity(Add): O(1)
Time Complexity(Remove): O(n)

FILES:
1. ICourse.java, 
2. Course.java, Allocate course, capacity & availability of courses.
3. IScheduler.java, Interface to Course.java
4. Scheduler.java, Responsible for scheduling courses to all students.
5. IStudent.java, Interface to Student.java
6. Student.java, Manage students, preference & allocation
7. Driver.java, File that has main function and allocate courses to students using multiple threads. 
8. FileDisplayInterface.java, Interface that write schedules to file.
9. Results.java, print the schedules, average preference score, etc
10. StdoutDisplayInterface.java, Interface that write schedules to stdout.
11. CreateWorkers.java, Allocate thread & cause threads to execute
12. WorkerThread.java, Allocate threads & cause threads to execute
13. CourseObjectPool.java, Manage courses, check availability etc.
14. FileProcessor.java,  Reads/ Write text from/ to a specified file.
15. Logger.java, Writes message to stdout depending on DEBUG_VALUE.
16. ObjectPool.java, Interface to CourseObjectPool.java
17. built.xml,
18. README.txt, The text file you are presently reading

Required (in src folder): 
input.txt, file that has the preference for courses

SAMPLE OUTPUT:
balakrishna@balakrishna-XPS-13-9343:~/workspace/DesignPatterns/balakrishna_lellapalli_assign2/balakrishna_lellapalli/registrationScheduler$ ant -buildfile src/build.xml run -Darg0=input -Darg1=output.txt -Darg2=3 -Darg3=0
Buildfile: /home/balakrishna/workspace/DesignPatterns/balakrishna_lellapalli_assign2/balakrishna_lellapalli/registrationScheduler/src/build.xml

jar:
    [mkdir] Created dir: /home/balakrishna/workspace/DesignPatterns/balakrishna_lellapalli_assign2/balakrishna_lellapalli/registrationScheduler/BUILD/jar
      [jar] Building jar: /home/balakrishna/workspace/DesignPatterns/balakrishna_lellapalli_assign2/balakrishna_lellapalli/registrationScheduler/BUILD/jar/registrationScheduler.jar

run:
     [java] DEBUG_VALUE=0 [Average preference_score is: 19.25]

BUILD SUCCESSFUL
Total time: 0 seconds


TO COMPILE (While in project directory):
1. Clean:
	ant -buildfile src/build.xml clean
2. Compile:
	ant -buildfile src/build.xml all 

TO RUN:
input.txt file is required in src folder.
Run:
ant -buildfile src/build.xml run -Darg0=input -Darg1=output.txt -Darg2=3 -Darg3=0

# Student Orientation


