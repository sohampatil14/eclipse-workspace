/*
 Create a Package Engineering which has two classes as Student and Marks. 
 Accept (n) student detail like roll_no, Subject_name, Student_name,
 calculate total marks in the class Student Write display() method to display details 
 and sort () method to sort the students records as per increasing order of the total marks. 
 The function sort must be statically defined to invoke it without referring any object. 
 Both the functions write in the Marks class.
 Create a main class which will use package display all the records of the student in the increasing order of the their total marks.
 */
package packageEngineering;
import java.util.*;
public class Students implements Comparable<Students> {
	
	int roll_no, n, total_marks; 			//data members
	String student_name;
	String[] subject_name;
	int[] sub_marks;

	Scanner s = new Scanner(System.in);
	
	public int getTotal() {		//returns total marks of student
		
		return total_marks;
	}
	
	public String getName() {	//returns name of student
		
		return student_name;
	}
	
	public Students(String sname, int roll, int[] marks, String[] subname, int total) {		//store records of students
	
		student_name = sname;
		roll_no = roll;
		total_marks = total;
		n = marks.length;
		sub_marks = new int[n];
		subject_name = new String[n];
		for(int i=0;i<marks.length;i++) {
			
			sub_marks[i] = marks[i];
			subject_name[i] = subname[i];
		}
	}
	
    public int compareTo(Students s1) {			//compare function to sort students records according total marks
        if (this.total_marks != s1.getTotal()) {
            return this.total_marks - s1.getTotal();
        }
        return this.student_name.compareTo(s1.getName());
    }
}

