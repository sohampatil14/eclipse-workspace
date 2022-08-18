package exp_5;

import java.util.Scanner;

public class knapSack_maxProfit_minmax {
	//function to find the max profit
	static int max(int low, int high, int a[]) {
		
		int max;
		if(low==high) {
			
			max = a[low];
			return max;	
		}
		
		else if((high-low)==1) {
			
			if (a[low]<a[high]) {
            	
            	max = a[high];
            } 
            else {
            	
            	max = a[low];
            }
			return max;			
		}
		
		else {
					
			int mid = low + (high-low)/2;
			int left = max(low,mid,a);
			int right = max(mid+1,high,a);
			if (left>right) {
				
				max = left;
			}
	        else {
	        	
	        	max = right;
	        }
		}
		return max;
	}
	
	//knapsack function
	public static void knapsack(int weight[], int profit[], int max_weight) {

        int control;
        int len = weight.length;
        double result[] = new double[len];
        for (control = 0; control < len; control++) {

            result[control] = 0.0;
        }
        int remain_weight = max_weight;
        for (control = 0; control < len; control++) {

            if (weight[control] > remain_weight) {
                break;
            }
            result[control] = 1.0;
            remain_weight = remain_weight - weight[control];
        }
        if (control <= len) {

            result[control] = (double) remain_weight / weight[control];
        }
        print_result(result);
        System.out.println();
        print_totalProfit(profit, result);
    }

	//function to print the total profit
    public static void print_totalProfit(int profit[], double result[]) {

        double totalProfit = 0;
        for (int i = 0; i < profit.length; i++) {

            totalProfit = (profit[i] * result[i]) + totalProfit;
        }
        System.out.println("The Total Profit is : " + totalProfit);
    }

    //printing the result = weight_taken/actual_weight
    public static void print_result(double result[]) {

        System.out.print(java.util.Arrays.toString(result));
    }

    //function to sort profit in descending order
	public static int[] desc_profit(int profit[]) {
		
		int new_profit[] = new int[profit.length];
		for(int control=0;control<profit.length;control++) {
			
			new_profit[control] = max(0,profit.length-1,profit);
			profit = reset(profit,new_profit[control]);
		}
		return new_profit;
	}
	
	
	//function to assign zero to used profit 
	public static int[] reset(int profit[],int _zero) {
		
		for(int i=0;i<profit.length;i++) {
			
			if(profit[i]==_zero) {
				
				profit[i] = 0;
			}
		}
		return profit;
	}
    
	//function to get weight according to sorted profit
	public static int[] sort_equivalence(int new_profit[], int profit_save[], int weight[]) {
		
		int new_weight[] = new int[weight.length];
		for(int control=0;control<weight.length;control++) {
			
			for(int i=0;i<weight.length;i++) {
				
				if(new_profit[control] == profit_save[i]) {
					
					new_weight[control] = weight[i];
				}
			}
		}
		return new_weight;
	}
	
	public static void main(String[] args) {
		
        System.out.print("Enter the number of items to choose for kanpsack : ");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int profit[] = new int[n];
        int weight[] = new int[n];
        System.out.print("Enter the weight of each element available : ");
        for (int i = 0; i < n; i++) {

            weight[i] = s.nextInt();
        }
        System.out.print("Enter the profit of each element available : ");
        for (int i = 0; i < n; i++) {

            profit[i] = s.nextInt();
        }
        System.out.print("Enter the max weight of sack : ");
        int max_weight = s.nextInt();
        int profit_save[] = new int[n];
        for(int i=0;i<n;i++) {
        	
        	profit_save[i] = profit[i];
        }
        int new_profit[] = desc_profit(profit);
        int new_weight[] = sort_equivalence(new_profit, profit_save, weight);
        knapsack(new_weight,new_profit,max_weight);        
	}

}