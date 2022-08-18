import java.util.Scanner;
public class LCMandGCD 
{
String a, b;
int num1, num2, temp, gcd, lcm;
public static boolean isNumeric(String a, String b)			//Checks the string is parsable or not
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
public int gcd(int num1, int num2)		//Calculating GCD
{
if (num1 == 0)					//Checking conditions on input
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
public int lcm(int gcd)				//Calculating LCM
{
if(gcd==0)					//Checking conditions on input
{
System.out.println("GCD is equal to 0. Error : Dividing by 0. Hence calculating LCM not possible.");
return 0;
}
temp = (num1 * num2) / gcd;
if(temp>=0)
{
return temp;
}
else
{
System.out.println("Warning : Negative Integer.");
return temp;
}
}
public void out(int num1, int num2, int gcd, int lcm)		//Displaying Output
{
System.out.println();
System.out.println("GCD [Greatest Common Divisor] of "+ num1 +" and "+ num2 +" is "+ gcd +".");
System.out.println();
System.out.println("LCM [Least Common Multiple] of "+ num1 +" and "+ num2 +" is "+ lcm +".");
}
public static void main(String[] args) 				//main() function
{
LCMandGCD lag = new LCMandGCD();
Scanner s = new Scanner(System.in);
System.out.println();
System.out.print("Enter the two numbers for calculating GCD [Greatest Common Divisor] and LCM [Least Common Multiple] : ");
lag.a = s.nextLine();		//Taking Input
lag.b = s.nextLine();
if(lag.isNumeric(lag.a, lag.b)) 	//Fucntion call
{ 
lag.num1 = Integer.parseInt(lag.a);
lag.num2 = Integer.parseInt(lag.b);
} 
else 
{
System.out.println("String is not numeric.");
System.exit(0);
}
lag.gcd = lag.gcd(lag.num1, lag.num2);			//Fucntion call
lag.lcm = lag.lcm(lag.gcd);				//Fucntion call
lag.out(lag.num1, lag.num2, lag.gcd, lag.lcm);		//Fucntion call
}
}