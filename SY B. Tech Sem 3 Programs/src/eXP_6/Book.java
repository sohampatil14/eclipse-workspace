package eXP_6;

public class Book {	
    String bookname;		//data members for Books
    String author;
    int availableBooks;
    String location;
    
    Book(String bkn, String auth, int avail, String locat){		//Book class constructor
    	
    	bookname = bkn;
    	author = auth;
    	availableBooks = avail;
    	location = locat;
    }
}