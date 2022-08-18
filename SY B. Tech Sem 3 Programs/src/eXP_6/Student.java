package eXP_6;

import java.util.Date;

public class Student implements functionsOnBook{		//extending functionsOnBook class for students to perform operations
    String studentName;
    int studentRoll;
    String issuedBookName = null;
    boolean isBookIssued = false;
    Date dateOfIssue = null;

    Student(String sname, int roll) {		//constructor for Students class
        studentName = sname;
        studentRoll = roll;
        issuedBookName = null;
        isBookIssued = false;
        dateOfIssue = null;
    }

    public boolean isAvailable(String bn, Book obj) {		//functions to check whether book is available or not
        if (bn.equals(obj.bookname)) {
            if (obj.availableBooks > 0) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public boolean bookIssue(String bk, Book obj) {		//function to issue book
        // * changes to student object
        issuedBookName = obj.bookname;
        isBookIssued = true;
        dateOfIssue = new Date();   // sets current day as date

        // !to make changes in Main class books vector (reducing availableBooks by 1)
         return true;
    }

    public String locateBook(String bn, Book obj) {		//function to locate book
        if (isAvailable(bn, obj)) {
            return "The book is in : " + obj.location;
        }
        else {
            return "The book is not available";
        }
    }

    public String bookReturn() {		//function to return book
        // * changes to student object
        String bn = issuedBookName;

        issuedBookName = null;
        isBookIssued = false;
        dateOfIssue = null;

        // ! to make changes in Main class books vector (increasing availableBooks by 1)
        return bn;
        // * returns bookname so that the bookname 
        // * can be used to locate book object in books vector
        // * to make changes to respective object
    }
}
