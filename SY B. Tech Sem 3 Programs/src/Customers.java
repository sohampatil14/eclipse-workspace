/*Write a program which accepts information about n no of customers from user.
Create an array of objects to store account_id, name, balance.
Your program should provide following functionalities
1.	To add account
2.	To delete any account detail
3.	To display account details.
*/
import java.util.Scanner;
class Customers
{
int account_id;								//Class variables
double balance;
String name;
Scanner s = new Scanner(System.in);
void add_account()							//Add account method
{
Scanner s = new Scanner(System.in);
System.out.print("Enter the name of customer : ");
name = s.nextLine();
System.out.print("Enter the account id for coustomer "+ name +" : ");
account_id = s.nextInt();
System.out.print("Enter the balance of account ID "+ account_id +" : ");
balance = s.nextDouble();
s.close();
System.out.println("Account details Entered.");
}
void display(int id)							//Display method
{
System.out.println("The name of customer is : "+ name);
System.out.println("The balance of account ID "+ account_id +" : "+ balance);
}
@SuppressWarnings("resource")
public static void main(String args[])					//main method
{
Scanner s1 = new Scanner(System.in);
int num_customers, ID, i, count = 0, choice, flag;
char ch;
System.out.print("Enter the number of customers you want to enter : ");
num_customers = s1.nextInt();						//number of customers
Customers[] c = new Customers[num_customers];				//declaring array of objects
for(i=0;i<num_customers;i++)
{
c[i] = new Customers();							//allocating memory
}
do
{
System.out.println("What would you like to do?");
System.out.println("1. Add account.");
System.out.println("2. Display the account details.");
System.out.println("3. Delete a account.");
System.out.println("4. Exit.");
choice = s1.nextInt();
switch(choice)
{
case 1:
c[count].add_account();							//add account method call
count++;
break;

case 2:
System.out.print("Enter the account ID you want to display : ");
ID = s1.nextInt();
flag = 0;
for(i=0;i<num_customers;i++)
{
try
{
if(c[i].account_id == ID)
{
c[i].display(ID);							//display account method call
flag = 1;
}
}
catch(NullPointerException e)
{
continue;
}
}
if(flag==0)
{
System.out.println("ID "+ ID +" doesn't exists.");
}
break;

case 3:
System.out.print("Enter the account ID you want to delete : ");
ID = s1.nextInt();
flag = 0;
for(i=0;i<num_customers;i++)
{
try
{
if(c[i].account_id == ID)
{
c[i] = null;								//deleting method
System.out.println("Account Deleted.");
flag = 1;
}
}
catch(NullPointerException e)
{
continue;
}
}
if(flag==0)
{
System.out.println("ID "+ ID +" doesn't exists.");
}
break;

case 4:
System.exit(0);

default:
System.out.println("Enter a value between 1 to 4.");
}
System.out.print("Would you like to repeat?");
ch = s1.next().charAt(0);
}while(ch=='Y');
}
}