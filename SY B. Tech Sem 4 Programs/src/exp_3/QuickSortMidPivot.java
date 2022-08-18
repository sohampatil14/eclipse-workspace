package exp_3;

import java.util.Scanner;

public class QuickSortMidPivot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int array1[];

        System.out.print("Enter the number of elements: ");
        int noOfElements = sc.nextInt();
        System.out.println();

        array1 = new int[noOfElements];

        System.out.println("Enter numbers as input for the array:");
        for (int i = 0; i < noOfElements; i++) {
            array1[i] = sc.nextInt();
        }

        System.out.println();

        System.out.println("The initial array is:\n");
        displayArray(array1, array1.length);

        System.out.println("\n Performing Quick Sort");
        quickSort(array1, 0, array1.length-1);

        System.out.println("After sort, the array is:\n");
        displayArray(array1, array1.length);

        sc.close();
    }

    // ! display function
    static void displayArray(int array[], int totalElements) {
        for (int i = 0; i < totalElements; i++) {
            System.out.print(array[i] + " ");
        }
    }

    // ! quick sort function
    static void quickSort(int arr[], int left, int right) {
        int pivot;
        if (left < right) {
            pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    static int partition(int a[], int left, int right) {
        // partition function finds the correct pivot
        // based on pivot, partions the array
        // values lower than pivot are on the left
        // values higher than pivot are on the right

        // setting pivot as mid
        int pivot = a[(left+right)/2];
        int low = left;
        int high = right;

        while (low < high) {
            while (pivot > a[low]) {
                low++;
            }
            while (low <= high && pivot < a[high]) {
                high--;
            }
            if (low <= high) {
                swap(a, low, high);
            }
        }
        return high;
    }

    static void swap(int a[], int first, int second) {
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }   
}