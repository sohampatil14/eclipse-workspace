/*Create a user defined exception subclass TrianlgeException 
with necessary constructors and overridden toString method. 
Write a program which accepts three sides of a triangle and 
throws an object of TriangleException class if Triangle is
not constructible otherwise it displays 
the types of triangle and area of triangle formed. 
On printing, the exception objects should display exception name, 
appropriate message and sides responsible for exception.*/

import java.util.*;

class TriangleException extends Exception
{
//	@Overriden toString()
	public String toString(double x, double y) {
		
	System.out.println("Triangle not constructible. Addition of two sides is less than other side. ");	
	return "Sides with problem are "+ x +" and "+ y;
  }
}

class TriangleArea {
  
	private double a,b,c;

	public TriangleArea(double _a, double _b, double _c) {		//constructor
	  	    
	    a = _a;
	    b = _b;
	    c = _c;
 	}

	public double getArea()  {
    
		double p, s;
	    p = (a+b+c)/2.0;
	    s = Math.sqrt(p*(p-a)*(p-b)*(p-c));			//calculating area Heron
	    return s;
	  }
	
	public void Type() {				//checking type of triangle
		
	    if(a==b && b==c && a==c) {
	    	
	    	System.out.println("Sides of triangle forms an equlilateral triangle.");
	    }
	    
	    else if(a==b || b==c || a==c) {
	    	
	    	System.out.println("Sides of triangle forms an isosceles triangle.");
	    }
	    
	    else {
	    	
	    	System.out.println("Sides of triangle forms a scalar triangle.");
	    }
	}
}

public class Triangle {

  public static void main(String[] args) {			//main method

	double a = 0.0, b= 0.0, c = 0.0;
    Scanner in = new Scanner(System.in);
    
    try {
    	
        System.out.print("Enter the first side of triangle : ");
        a = in.nextDouble();				//accepting input
    }
    catch(InputMismatchException e1) {
    	
    	System.out.println("Please enter integer or double value.");
    	System.exit(0);
    }
    
    try {
    	
        System.out.print("Enter the second side of triangle : ");
        b = in.nextDouble();			//accepting input
    }
    catch(InputMismatchException e2) {
    	
    	System.out.println("Please enter integer or double value.");
    	System.exit(0);
    }
    
    try {

        System.out.print("Enter the third side of triangle : ");
        c = in.nextDouble();  			//accepting input
    }
    catch(InputMismatchException e1) {
    	
    	System.out.println("Please enter integer or double value.");
    	System.exit(0);
    }

    System.out.println();
    
    try {
	    
    	if (((a+b)<c)) {			//checking sum of sides a and b
    		
    		throw new TriangleException();	//throwing exception
    	}
    }
    catch(TriangleException e) {	//catching exception
    	
      System.out.println("Exception: "+e.toString(a, b));
      System.exit(0);
    }
    
    try {
        
    	if (((a+c)<b)) {			//checking sum of sides a and c
    		
    		throw new TriangleException();	//throwing exception
    	}
    }
    catch(TriangleException ee) {	//catching exception
    	
      System.out.println("Exception: "+ee.toString(a, c));
      System.exit(0);
    }
    
    try {
        
    	if (((b+c)<a)) {			//checking sum of sides b and c
    		
    		throw new TriangleException();	//throwing exception
    	}
    }
    catch(TriangleException eee) {	//catching exception
    	
      System.out.println("Exception: "+eee.toString(b, c));
      System.exit(0);
    }
    
    TriangleArea tr = new TriangleArea(a,b,c);	//creating TriangleArea object
    tr.Type();	//checking type of triangle
    double area = tr.getArea();	//calculating area of triangle
    System.out.println();
    System.out.println("Area of triangle formed by given sides is : " + area);		//printing area
  }
}