package eXP_6;

import java.util.*;

public class Main {
    
  static Vector<Book> books = new Vector<Book>();			//Vector for storing book data
  static Vector<Student> students = new Vector<Student>();		//Vector for storing students data for login

  public static void authenticatedUserOperations(int studentIndex) {	

	Scanner sc = new Scanner(System.in);

    int willContinue = 1;

    while(willContinue == 1 ){

      int choice, i, index = 0;

      System.out.println("What operation you want to perform:");		//asking fot user for which operation to perform
      System.out.println("1. Check for availability of book");
      System.out.println("2. Check for location of book");
      System.out.println("3. Issue a new book");
      System.out.println("4. Return a new book");
      System.out.println("5. Logout");
      choice = sc.nextInt();

      switch(choice){

        case 1: {
            String bookName = null;
            System.out.println("Enter the book name you want to search the availability for:- ");
            sc.nextLine();
            try {
            	bookName = sc.nextLine();
            }
            catch(InputMismatchException e) {
          	  System.out.println("Enter a string.");
            }
            for(i=0;i<books.size();i++) {
          	  
          	  if(bookName.equals(books.get(i).bookname)) {		//checking name of book in vector
          		  
          		  index = i;
          		  break;
          	  }
          	  if(i==books.size()-1) {
          		  System.out.println("The book you searched for is not available.");
          	  }
            }
            if(students.get(studentIndex).isAvailable(bookName, books.get(index))) {
          	  
          	  System.out.println("The number of available books : "+books.get(index).availableBooks);		//printing number of available books
            }
        }

        case 2: {
          String bookName = null;
          System.out.println("Enter the book name you want to search the location for:- ");
          try {
        	  bookName = sc.nextLine();
          }
          catch(InputMismatchException e) {
        	  System.out.println("Enter a string.");
          }
	        for(i=0;i<books.size();i++) {
	      	  
	      	  if(bookName.equals(books.get(i).bookname)) {		//checking name of book in vector
	      		  
	      		  index = i;
	      		System.out.println("The book is located at : "+students.get(studentIndex).locateBook(bookName, books.get(index))); //printing location of book
	      		  break;
	      	  }
	      	  if(i==books.size()-1) {
	      		  System.out.println("The book you searched for is not available.");
	      	  }
	        }
        }

        case 3: {
          String bookName = null;
          System.out.println("Enter the book name which you want to issue:- ");
          try {
          bookName = sc.nextLine();
          }
          catch(InputMismatchException e) {
        	  System.out.println("Enter a string.");
          }
            for(i=0;i<books.size();i++) {
          	  
          	  if(bookName.equals(books.get(i).bookname)) {		//checking book name
          		  
          		  index = i;
          		  if(students.get(studentIndex).bookIssue(bookName, books.get(index))) {	//issuing books	
          			  
          			  books.get(index).availableBooks--;	
          		  }
          		  System.out.println("Book Issued. Available Books : "+books.get(index).availableBooks);
          		  break;
          	  }
          	  if(i==books.size()-1) {
          		  System.out.println("The book you searched for is not available.");
          	  }
            }
            
        }

        case 4: {
        	
        	if(students.get(studentIndex).issuedBookName==null) {
        		System.out.println("No book issued by you.");
        		break;
        	}
        	System.out.println("Books Issued by you : "+students.get(studentIndex).issuedBookName);		//checking issued books
        	System.out.println("Do you want to return the book. Type yes and enter.");
        	String check = sc.nextLine();
        	String bookName = null;
        	if(check.equals("YES") || check.equals("yes") || check.equals("Yes")) {
        		
        		bookName = students.get(studentIndex).bookReturn();		//returning books
        	}
        	try {
            for(i=0;i<books.size();i++) {
            	  
            	  if(bookName.equals(books.get(i).bookname)) {
            		  
            		  index = i;
            		  if(students.get(studentIndex).bookIssue(bookName, books.get(index))) {
            			  
            			  books.get(index).availableBooks++;
            		  }
            		  System.out.println("Book Returned. Available Books : "+books.get(index).availableBooks);
            		  break;
            	  }
        }
        }
        	catch(NullPointerException e) {
        		System.out.println("No book issued by you.");
        	}
        }

        case 5: {
          System.out.println("Session ended. Login again to open session again.");
          // willContinue = false;
          return;
        }


        default:
          System.out.println("Please enter the valid numbers only");
          break;
      }

      System.out.println("\n\nDo you want to redo the operations \n If yes, enter 1 else 0 :- ");
      willContinue = sc.nextInt();
     
      }

  }

  public static void login(String name, int rollNo){		//login function

    boolean doesStudentExist = false;
    int i = 0;
    for (i = 0; i < students.size(); i++) {
      if (students.get(i).studentName.equals(name) && rollNo == students.get(i).studentRoll) {
        doesStudentExist = true;
        break;
      }
    }

    if(!doesStudentExist){
      System.out.println("Invalid data. No Student found");
      return;
    }

    authenticatedUserOperations(i);			//call to function to operations for book
  }


  public static void main(String []args){

    books.add(new Book("COA","William Stallings",3,"Shelf : 1\t" + "Row : 3"));			//initalizing vectors
    books.add(new Book("DS","Seymour Lipschutz",4,"Shelf : 1\t" + "Row : 2"));
    books.add(new Book("JAVA","Herbet Schildt",3,"Shelf : 1\t" + "Row : 4"));
    books.add(new Book("MICRO","Doughals Hall",5,"Shelf : 2\t" + "Row : 1"));
    books.add(new Book("OS","Silberschatz, Galvin, Gagne",2,"Shelf : 2\t" + "Row : 3"));

    students.add(new Student("Yash Kulkarni", 803));
    students.add(new Student("Krish Panchal", 806));
    students.add(new Student("Soham Patil", 810));


    int willContinue = 1;

    while (willContinue == 1){

      @SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
      String name = null;
      int rollNo = 0;

      System.out.println("------- Login --------");
      System.out.println("Enter your name:- ");			//taking login credentials
      try {
      name = sc.nextLine();
      }
      catch(InputMismatchException e) {
    	  System.out.println("Enter your roll number.");
      }      System.out.println("Enter your Roll No:- ");
      try {
      rollNo = sc.nextInt();
      }
      catch(InputMismatchException e) {
    	  System.out.println("Enter your roll number.");
      }
      login(name, rollNo);

      System.out.println("\n\nDo you want to login again ?\n If yes, enter 1 else 0 :- ");
      willContinue = sc.nextInt();

    }
  }
}
