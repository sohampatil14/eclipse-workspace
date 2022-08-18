//Program to calculate factorial, power to exponent and sin and cos series to n terms
import java.util.Scanner;
public class myMath
{
static String a, b, c;							//Declaring Variables
static double x, y, n, pow, fact, cos, sin, sign, sign2, div, div2, p, q, r;
static int i, j;
public static boolean isNumeric(String a, String b, String c)		//Checks the string is parsable or not
{
if(a == null && a.equals("") && b == null && b.equals("") && c == null && c.equals("")) 
{
System.out.println("String cannot be parsed, it is null or empty.");
return false;
}
if(a.contains(".") || (b.contains(".") || c.contains(".")))
{
System.out.println("Cannot operate on double. Please enter an integer string.");
return false;
}
try 
{
p = Double.parseDouble(a);
q = Double.parseDouble(b);
r = Double.parseDouble(c);
return true;
} 
catch (NumberFormatException e) 
{
}
return false;
}
static double pow(double x, double y)					//Calculating power of x to y without using recurssion
{
pow = 1.0;
for(i=1;i<=y;i++)
{
pow = pow*x; 
}
return pow;
}
static double fact(double x)						//Calculating factorial of x without using recurssion
{
fact = 1.0;
for(i=1;i<=x;i++)
{
fact = fact * i;
}
return fact;
}
static double cos(double x, double n)					//Calculating cos(x)
{
double cos = 0.0, div = 0.0, sign = 1.0;
for(j=0;j<=(n*2)-1;j=j+2)
{
div = (pow(x,j) / fact(j));
cos = cos + (sign * div);
sign = sign * -1;
}
return cos;
}
static double sin(double x, double n)					//Calculating sin(x)
{
double sin = 0.0, div2 = 0.0, sign2 = 1.0;
for(j=1;j<=(n*2);j=j+2)
{
div2 = (pow(x,j) / fact(j));
sin = sin + (sign2 * div2);
sign2 = sign2 * -1;
}
return sin;
}
public static void main(String args[])					//main() function
{
Scanner s = new Scanner(System.in);					//Taking Inputs
System.out.print("Enter a number to calculate factorial : ");
a = s.nextLine();
System.out.print("Enter a number to calculate power of previous number to : ");
b = s.nextLine();
System.out.print("Enter a number to calculate sin and cosine series to number of terms : ");
c = s.nextLine();
if(isNumeric(a, b, c)) 		//Function call
{ 
x = Integer.parseInt(a);
y = Integer.parseInt(b);
n = Integer.parseInt(c);
} 
else 
{
System.out.println("String is not numeric.");
System.exit(0);
}
System.out.println("Factorial of the " + x + " is : " + fact(x));		//Function call to fact(int)
System.out.println("Power of " + x + " to " + y + " is : " + pow(x,y));		//Function call to pow(int,int)
System.out.println("Cosine series of " + x + " is for " + n + " number of terms : " + cos(x,n));	//Function call to cos(int,int)
System.out.println("Sin series of " + x + " is for " + n + " number of terms : " + sin(x,n));		//Function call to sin(int,int)
}
}