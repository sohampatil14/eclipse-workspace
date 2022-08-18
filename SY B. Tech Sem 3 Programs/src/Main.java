/*
 Create a Package Engineering which has two classes as Student and Marks. 
 Accept (n) student detail like roll_no, Subject_name, Student_name,
 calculate total marks in the class Student Write display() method to display details 
 and sort () method to sort the students records as per increasing order of the total marks. 
 The function sort must be statically defined to invoke it without referring any object. 
 Both the functions write in the Marks class.
 Create a main class which will use package display all the records of the student in the increasing order of the their total marks.
 */
import packageEngineering.*;			//importing classes from packageEngineering
import java.util.*;
public class Main {

	public static void main(String[] args) {		//main method
		
		Scanner s = new Scanner(System.in);
		int num_students, i, total, roll, n; 
		String sname;
		int[] marks;
		String[] subname;
		System.out.print("Enter the number of students data you want to enter : ");
		num_students = s.nextInt();				//taking the number of student record to enter
		Students[] S = new Students[num_students];				//declaring array of objects
		for(i=0;i<num_students;i++) {
			
			total = 0;
			System.out.print("Enter the student name : ");		//Asking user the details of students
			s.nextLine();
			sname = s.nextLine();
			System.out.print("Enter the student roll number : ");
			roll = s.nextInt();
			System.out.print("How many subjects you want to enter : ");
			n = s.nextInt();
			marks = new int[n];
			subname = new String[n];
			for(int j=0;j<n;j++) {
				
				System.out.print("Enter the subject name : ");
				s.nextLine();
				subname[j] = s.nextLine();
				System.out.print("Enter the marks for "+ subname[j] +" : ");
				marks[j] = s.nextInt();
				total = total + marks[j];		//calculating total marks of students
			}
			
			S[i] = new Students(sname, roll, marks, subname, total);							//allocating memory
			System.out.println();
		}

		Marks m = new Marks();			//creating marks object
		Marks.sort(S);					//sorting student record in array of object according to total marks
		for(i=0;i<num_students;i++) {
			
			m.display(S[i]);		//displaying records of students 
		}
	}
	
}
