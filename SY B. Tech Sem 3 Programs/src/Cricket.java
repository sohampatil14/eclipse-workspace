/*Write a program which stores information about n players in a two-dimensional array. 
The array should contain number of rows equal to number of players. 
Each row will have number of columns equal to number of matches played by that player which may vary from player to player. 
The program should display player number (index +1), runs scored in all matches and its batting average as output. 
(It is expected to assign columns to each row dynamically after getting value from user.
*/
import java.util.*;
public class Cricket
{
public static void main(String args[])						//main() function
{
int num_players, num_matches = 0, i, j, k, max_matches, n1, n2;			//variable declaration
double average, sum, count;
Scanner s = new Scanner(System.in);
System.out.print("Enter the number of players you want to enter : ");		//user input
num_players = s.nextInt();
int[][] match = new int[num_players][];						//array declaration and rows initialization
System.out.print("Enter the maximum number of matches played by player : ");	//user input
max_matches = s.nextInt();
for(i=0;i<num_players;i++)
{
n1 = i+1;
System.out.print("Enter the number of matches played by player "+ n1 +" : ");	//user input
num_matches = s.nextInt();
match[i] = new int[max_matches];						//columns initialization
if(max_matches>=num_matches)
{
for(j=0;j<max_matches;j++)
{
if(num_matches-j>0)
{
n2 = j+1;
System.out.print("Enter the runs scored by player "+ n1 +" in match "+ n2 +" : ");	//user input
match[i][j] = s.nextInt();
}
else
{
match[i][j] = -1;
}
}
}
else
{
System.out.println("Please enter matches played within the maximum number of matches played by player.");		//user input
System.exit(0);
}
System.out.println();
}
for(i=0;i<=max_matches;i++)
{
System.out.print("----------------------------");
}
System.out.println();
System.out.print("Players\t\t|\t");
for(i=1;i<=max_matches;i++)
{
System.out.print("Match No. "+ i + "\t|\t");						//Match Number
}
System.out.print("Batting Average");
System.out.println();
for(i=0;i<=max_matches;i++)
{
System.out.print("----------------------------");
}
System.out.println();
for(i=0;i<num_players;i++)
{
sum = 0.0;
count = 0.0;
n1 = i+1;
System.out.print("Player No. "+ n1 +"\t|\t");						//Player Number
for(j=0;j<max_matches;j++)
{
if(match[i][j]==-1)
{
System.out.print("No Record\t|\t");
}
else
{
System.out.print(match[i][j] + "\t\t|\t");						//Print Runs 
sum = sum + match[i][j];								//Sum calculation
count = count + 1.0;
}
}
average = sum / count;									//Average Calculation
System.out.print(average);								//Print Average
System.out.println();
for(k=0;k<=max_matches;k++)
{
System.out.print("----------------------------");
}
System.out.println();
}
}
}