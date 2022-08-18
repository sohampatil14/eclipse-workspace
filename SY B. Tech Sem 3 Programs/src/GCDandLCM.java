import java.util.Scanner;
public class GCDandLCM 
{
public static boolean isNumeric(String a, String b)		//Checks the string is parsable or not
{
int x, y;
if(a == null || a.equals("") && b == null || b.equals("")) 
{
System.out.println("String cannot be parsed, it is null or empty.");
return false;
}
try 
{
x = Integer.parseInt(a);
y = Integer.parseInt(b);
return true;
} 
catch (NumberFormatException e) 
{
}
return false;
}
public static int gcd(int num1, int num2)		//Calculating GCD	
{
if (num1 == 0)						//Checking conditions on input
{
return num2;
}
if (num2 == 0)
{
return num1;
}  
if (num1 == num2)
{
return num1;
}
if (num2 != 0)
{
return gcd(num2, num1 % num2);
}
else
{
return num1;
}
}
public static int lcm(int num1, int num2, int gcd)		//Calculating LCM
{
if(gcd==0)							//Checking conditions on input
{
System.out.println("GCD is equal to 0. Error : Dividing by 0. Hence calculating LCM not possible.");
return 0;
}
int temp = (num1 * num2) / gcd;
if(temp>=0)
{
return temp;
}
else
{
System.out.println("Warning : Negative Integer.");
return 0;
}
}
public static void main(String[] args)			//main() function
{
String a, b;
Scanner s = new Scanner(System.in);
System.out.println();
System.out.print("Enter the two numbers for calculating GCD [Greatest Common Divisor] and LCM [Least Common Multiple] : ");
a = s.nextLine();		//Taking Input
b = s.nextLine();
int num1 = 0, num2 = 0;
if(isNumeric(a, b)) 		//Fucntion call
{ 
num1 = Integer.parseInt(a);
num2 = Integer.parseInt(b);
} 
else 
{
System.out.println("String is not numeric.");
System.exit(0);
}
int gcd = gcd(num1, num2);		//Fucntion call
int lcm = lcm(num1, num2, gcd);		//Fucntion call
System.out.println();					//Printing result
System.out.println("GCD [Greatest Common Divisor] of "+ num1 +" and "+ num2 +" is "+ gcd +".");
System.out.println();
System.out.println("LCM [Least Common Multiple] of "+ num1 +" and "+ num2 +" is "+ lcm +".");
}
}