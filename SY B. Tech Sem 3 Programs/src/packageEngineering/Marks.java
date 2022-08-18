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

public class Marks {
		
	int i;
	
	public void display(Students s) {		//displaying information on students
		
		System.out.println("Student Name : "+ s.student_name);
		System.out.println("Student Roll No. : "+ s.roll_no);
		System.out.println();
		for(i=0;i<s.sub_marks.length;i++) {
			
			System.out.println("Subject Name : "+ s.subject_name[i]);
			System.out.println("Marks : "+ s.sub_marks[i]);
			System.out.println();
		}		
		System.out.println("Total Marks : "+ s.total_marks);
		System.out.println();
	}
	
	public static void sort(Students[] s) {		//sorting students records according to total marks
		
		Arrays.sort(s);
	}
}
