package exp_10;

import java.util.Scanner;

public class Longest_Common_subSequence {
		
	static int count;
	
    public static void lcs(String a1, String a2, int len1, int len2) {

        int cost_matrix[][] = new int[len1+1][len2+1];
        int direction_matrix[][] = new int[len1+1][len2+1];
//        int i, j = 0;
        int n1 = 0, n2 = 0;
        for (int i = 0; i <= len1; i++) {  
            for (int j = 0; j <= len2; j++) {  

                if(i==0 || j==0) {

                    cost_matrix[i][j] = 0;
                }
                else if(a1.charAt(i-1) == a2.charAt(j-1)) {

                    cost_matrix[i][j] = cost_matrix[i-1][j-1] + 1;
                    direction_matrix[i][j] = 0;
                }
                else if(cost_matrix[i-1][j] >= cost_matrix[i][j-1]) {

                    cost_matrix[i][j] = cost_matrix[i-1][j];
                    direction_matrix[i][j] = 1;
                }
                else {

                    cost_matrix[i][j] = cost_matrix[i][j-1];
                    direction_matrix[i][j] = -1;
                }
                n2 = j;
            }
            n1 = i;
        }
        System.out.println();
        System.out.print("The Largest Common Subsequence is : ");
        print_subSequence(direction_matrix, a1, n1, n2, count);
        displayCount(count);
    }
    
    public static void increment() {
    	
    	count++;
    }

    public static void print_subSequence(int direction_matrix[][], String a1, int i, int j, int count) {

        if(i==0 && j==0) {

            return;
        }
        if(direction_matrix[i][j] == 0) {

        	if(i-1>=0 && j-1>=0) {
        		print_subSequence(direction_matrix, a1, i-1, j-1, count);
        		System.out.print(a1.charAt(i-1));
        		increment();
        	}
        }
        else if(direction_matrix[i][j] == 1) {

        	if(i-1>=0 && j-1>=0) {
        		
        		print_subSequence(direction_matrix, a1, i-1, j, count);            
        	}
        }
        else {

        	if(i-1>=0 && j-1>=0) {
        		
        		print_subSequence(direction_matrix, a1, i, j-1, count);
        	}
        }
//		return count;
    }
    
    public static void displayCount(int count) {
    	
    	System.out.println();
    	System.out.println();
        System.out.print("Length of Longest Common Subsequence is : "+count);
    }

    public static void main(String args[]) {

        String input_1, input_2;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the input string 1 (in all Capital Letters) : ");
        input_1 = s.nextLine();
        System.out.print("Enter the input string 2 (in all Capital Letters) : ");
        input_2 = s.nextLine();
        lcs(input_1, input_2, input_1.length(), input_2.length());
    }
}