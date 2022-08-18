package eXP_6;

public interface functionsOnBook {
    public boolean isAvailable(String bn, Book obj);		//abstract methods for functions on books 
    public boolean bookIssue(String bk, Book obj);
    public String locateBook(String bn, Book obj);
    public String bookReturn();    
}