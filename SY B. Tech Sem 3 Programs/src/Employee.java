/*Experiment 5
Create a class Employee which stores E-Name, E-Id and E-Salary of an Employee. 
Use class Vector to maintain an array of Employee with respect to the E-Salary. 
Provide the following functions
1) Create (): this function will accept the n Employee records in any order and will arrange them in the sorted order.
2) Insert (): to insert the given Employee record at appropriate index in the vector depending upon the E-Salary.
3) delete ByE-name( ): to accept the name of the Employee and delete the record having given name
4) deleteByE-Id ( ): to accept the Id of the Employee and delete the record having given E-Id.*/
import java.util.*;
public class Employee implements Comparable<Employee>{

	int e_id;
	double e_salary;
	String e_name;
	
	Employee(String ename, double esalary, int eid) {			//constructor
		
		e_id = eid;
		e_name = ename;
		e_salary = esalary;	
	}

	int getId() {
		
		return this.e_id;
	}
	
	double getSalary() {
		
		return this.e_salary;
	}
	
	String getName() {
		
		return this.e_name;
	}
	
	public int compareTo(Employee otherEmployee) {			//compare method for sorting

		return (int) (this.getSalary()-otherEmployee.getSalary());
	}
	
	public static void main(String[] args) {			//main function

		int n, choice, id, i, count, num;
		double salary;
		String name;
		char ch;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the number of employees you want to enter : ");
		n = s.nextInt();							//number of employees
		Vector<Employee> v = new Vector<Employee>(n);		//creating vector with number of employees
		num = 0;
		count = 0;
		do
		{
		System.out.println("Enter the operation you want to do : ");		//asking user for its operation
		System.out.println("1. Create a new employee record.");
		System.out.println("2. Insert a new employee record according to employee salary.");
		System.out.println("3. Add employee record at the end of all records.");
		System.out.println("4. Delete employee record using employee name.");
		System.out.println("5. Delete employee record using employee id.");
		System.out.println("6. Display record by employee salary.");
		System.out.println("7. Exit");
		choice = s.nextInt();
		switch(choice)
		{
		
		case 1:
			System.out.println("Enter the salary of employee : ");
			salary = s.nextDouble();
			s.nextLine();
			System.out.println("Enter the name of employee : ");
			name = s.nextLine();
			System.out.println("Enter the employee id : ");
			id = s.nextInt();
			num++;
			try {
	
				v.add(new Employee(name, salary, id));			//adding employee record into vector
			}
			catch(ArrayIndexOutOfBoundsException e) {
				
				System.out.print("Employee information cannot be entered.");
				break;
			}
			System.out.print("Employee information entered.");
			Collections.sort(v);							//sorting according to salary
			break;
			
		case 2:
			System.out.println("Enter the salary of employee : ");
			salary = s.nextDouble();
			s.nextLine();
			System.out.println("Enter the name of employee : ");
			name = s.nextLine();
			System.out.println("Enter the employee id : ");
			id = s.nextInt();
			count = 0;
			for(i=0;i<num;i++) {
				
				if(salary<=v.get(i).getSalary()) {
					
					count++;
				}
			}
			num++;
			try {
				
				v.add(count, new Employee(name, salary, id));		//adding into vector according to salary
			}
			catch(ArrayIndexOutOfBoundsException e) {
				
				System.out.print("Employee information cannot be entered.");
				break;
			}
			System.out.print("Employee information entered.");
			break;
		
		case 3:
			System.out.println("Enter the salary of employee : ");
			salary = s.nextDouble();
			s.nextLine();
			System.out.println("Enter the name of employee : ");
			name = s.nextLine();
			System.out.println("Enter the employee id : ");
			id = s.nextInt();
			num++;		
			v.addElement(new Employee(name, salary, id));		//adding at the end of vector
			System.out.print("Employee information entered.");
			break;
			
		case 4:
			System.out.print("Enter the name of employee you want to delete : ");
			s.nextLine();
			name = s.nextLine();
			try {
			
				for(i=0;i<num;i++) {
					
					if(v.get(i).getName().equals(name)) {
						
						break;
					}
				}
	
				v.removeElementAt(i);					//deleting using name
			}
			catch(ArrayIndexOutOfBoundsException e) {
				
				System.out.print("Employee with name "+ name +" not found.");
				break;
			}
			System.out.println("Employee "+ name +" is deleted.");			
			break;
		
		case 5:
			System.out.print("Enter the Id of employee you want to delete : ");
			id = s.nextInt();
			for(i=0;i<num;i++) {
				
				if(id==v.get(i).getId()) {
					
					break;
				}
			}
			try {
				
				v.removeElementAt(i);			//deleting by id
			}
			catch(ArrayIndexOutOfBoundsException e) {
				
				System.out.print("Employee with Id "+ id +" not found.");
			}
			System.out.println("Employee with Id "+ id +" is deleted.");
			break;
			
		case 6:
			for(Employee e : v) {
			
				System.out.println("Name : "+ e.e_name);
				System.out.println("Id : "+ e.e_id);
				System.out.println("Salary : "+ e.e_salary);		//printing all records			
			}											
			
			break;
			
		case 7:
			System.exit(0);
			break;
			
		default:
			System.out.print("Enter value between 1 to 6.");
		}
		System.out.println();
		System.out.print("Do you want to repeat. Enter Y.");
		ch = s.next().charAt(0);
		}while(ch=='Y');
		s.close();
	}

}
