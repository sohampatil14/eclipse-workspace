package exp_3;

import java.util.*;

public class QuickSort {

    static int n;
    static int arr[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Element %d: ", i + 1);
            arr[i] = sc.nextInt();
        }
        System.out.print("Elements of array are: ");
        System.out.println(java.util.Arrays.toString(arr));
        System.out.print("Sorted array: ");
        quickSort(arr, 0, n - 1);
        System.out.println(java.util.Arrays.toString(arr));
        sc.close();
    }

    public static void quickSort(int arr[], int left, int right) {
        int q;
        if (left < right) {
            q = partition(arr, left, right);
            quickSort(arr, left, q - 1);
            quickSort(arr, q + 1, right);
        }
    }

    public static int partition(int arr[], int left, int right) {
        int pivot = arr[left];
        int low = left + 1;
        int high = right;

        do {

            while (arr[high] > pivot) {
                high -= 1;
            }
            while (low <= high && arr[low] <= pivot) {
                low += 1;
            }
            if (low <= high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }

        } while (low < high);

        int temp = arr[left];
        arr[left] = arr[high];
        arr[high] = temp;

        return high;
    }
}

