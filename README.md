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

# Word Count


PURPOSE:
"wc" command with Visitor, Prototype, and Observer 

DATA STRUCTURE:
Trie Data Structure: 
Each trie node can only contains 'a'-'z' characters. So we can use a small array to store the character.
1. Create Trie : O (W * L)	W is number of words and L is average length of word.
	Lookup : L look up on an average for each of the W word.
	Insertion: For each word you need to compare, which takes O(L) and overall complexity of O (W * L)

2. ArrayList: For storing Observer (node). 
	Current we have a single back up tree so for each node there would be 1 backup node.
	Considering there can be more back up tree in future, there would be more backup node required.
	Arraylist grows by 50% of its previous size and I have not used Vector becuase Vectors are synchronized and there is only 1 thread so have not used vector in this case.
	Time Complexity(Add): O(1)
	Time Complexity(Get): O(1)
	Time Complexity(Remove): O(n)

FILES:
1. Driver.java, File that has main function and Call visitor (Populate, Word count, Clone and Observe vistor)
2. Node.java, It stores word, occurrence, list of observer and child nodes
3. Trie.java, Build tree by finding index of the array and inserting node to tree
4. ObserverI.java, update node's occurrence if there is change in original node's occurrence
5. SubjectI.java, Have functions to register other nodes, unregister other nodes and notify (observer)them if there is any change in subject.
6. FileProcessor.java, Reads/ Write text from/ to a specified file.
7. Logger.java, Class to write message to standard out depending on DEBUG_VALUE
8. CloneAndObserverVisitor.java, Visitor that clone each node from the tree and form back up tree also register each node of the tree (Observer pattern)
9. DSProcessingVisitorI.java, Visitor Interface
10. PopulateVisitor.java, Visitor class that reads words from a file and populates a data structure
11. UpdateTreeVisitor.java, Visitor that updates occurrence of all word in original tree and also notify all listener node on each update
12. WordCountVisitor.java, Visitor that determines the total number of words, total number of unique words, and characters stored in the data structure
13. built.xml, file responsible to build, compile, compress and run the project


Required (in project folder): 
input.txt, file that has to be read and process it

SAMPLE OUTPUT:
balakrishna@balakrishna-XPS-13-9343:~/Downloads/balakrishna_lellapalli_assign4/wordCount$ ant -buildfile build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=10
Buildfile: /home/balakrishna/Downloads/balakrishna_lellapalli_assign4/wordCount/build.xml

jar:

run:
     [java] Total Time : 10 ms

BUILD SUCCESSFUL
Total time: 0 seconds

Files Created:
result_original.txt - List of words and their occurrence before update [Original Tree]
result_updated.txt - List of words and their occurrence after update [Original Tree]
result_backup.txt - List of words and their occurrence after update [Backup tree]


TO COMPILE (While in project directory (wordCount)):
1. Clean:
	ant -buildfile build.xml clean
2. Compile:
	ant -buildfile build.xml all

TO RUN:
input.txt file is required in project folder. (wordCount)
Run from wordCount directory:
ant -buildfile build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=10
