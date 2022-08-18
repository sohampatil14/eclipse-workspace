package exp_3;



class sortQuick {
	  static int partition(int array[], int low, int high) {
		    
		    int pivot = array[high];
		    int i = (low - 1);
		    
		    
		    int j = low;
		    while(j<high) {
		    	
		    	if(array[j]<=pivot) {
		    		i++;
		    		int temp = array[i];
		    		array[i] = array[j];
		    		array[j] = temp;		    		
		    	}
		    	j++;
		    }
		    
		    int temp = array[i + 1];
		    array[i + 1] = array[high];
		    array[high] = temp;
		    return (i + 1);
	  }
	
	  static void quickSort(int array[], int low, int high) {
	
			  if (low < high) {
		
				  int pi = partition(array, low, high);
				  quickSort(array, low, pi - 1);
				  quickSort(array, pi + 1, high);
			  }
	  }
	
	public static void main(String args[]) {

    int[] data = { 7, 2, 9, 3, 1, 6, 7, 8, 4 };
    System.out.println("Unsorted Array");
    for(int i=0;i<data.length;i++) {
    	
    	System.out.print(data[i]);
    }

    int size = data.length;

    quickSort(data, 0, size - 1);

    System.out.println("Sorted Array in Ascending Order ");
    for(int i=0;i<data.length;i++) {
    	
    	System.out.print(data[i]);
    }
  }
}