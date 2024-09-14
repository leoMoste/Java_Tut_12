
public class Main {

	public static void main(String[] args) {
		int[] arr = {5, 2, 9, 1, 6};
		
		// Print sorted array
        System.out.println("Unsorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

		// Version 1)
		// this version will throw an Exception outOfBound
		/*for (int i = 0; i < arr.length; i++) {      // Notice i < arr.length here
		    for (int j = 0; j < arr.length; j++) {    // This will cause an issue
		        if (arr[j] > arr[j + 1]) {            // =>here will crash the programm beacuse will not find the index 5        // Compare adjacent elements
		            // Swap arr[j] and arr[j + 1]
		            int temp = arr[j];
		            arr[j] = arr[j + 1];
		            arr[j + 1] = temp;
		        }
		    }
		}*/

		// Version 2)
		// this version will work Logiclly fine but it has performance problem
		// therefore we need to stop the outter itration if the Array is sorted
        // because it will iterate extra itration after the sort and that not nessary
		
        /*
		for (int i = 0; i < arr.length; i++) {        // Notice i < arr.length here
		    for (int j = 0; j < arr.length - 1; j++) {    // This will cause an issue
		        if (arr[j] > arr[j + 1]) {          // Compare adjacent elements
		            // Swap arr[j] and arr[j + 1]
		            int temp = arr[j];
		            arr[j] = arr[j + 1];
		            arr[j + 1] = temp;
		        }
		    }
		}
		*/
		
		// Version 3)
		// this version it the best one because will take care of
		// the Logical part and the performance part to stop the 
		// outter loop if it find the loop is sorted 
		
		for (int i = 0; i < arr.length - 1; i++) {    // Correct: i < arr.length - 1: the performance part To avoid extra Itration after the sort complete
		    for (int j = 0; j < arr.length - 1; j++) {    // Correct: j < arr.length - 1: Logical part To avoid the out of bound exception
		        if (arr[j] > arr[j + 1]) {            // Compare adjacent elements
		            // Swap arr[j] and arr[j + 1]
		            int temp = arr[j];
		            arr[j] = arr[j + 1];
		            arr[j + 1] = temp;
		        }
		    }
		}
		
		/**
		 * Bubble Sort works by pushing the largest unsorted element to the end in each pass
		*/
		
		//  Version 4) Using External Function to make the steps of the Algorithim
	    // Bubble Sort with separate comparison and swapping functions
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (compare(arr[j], arr[j + 1])) {
                    swap(arr, j, j + 1);
                }
            }
        }
		
        
     // Print sorted array
        System.out.println("\nSorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
	
	}
	
	   // Function to compare two elements
    public static boolean compare(int a, int b) {
        return a > b;  // Return true if a is greater than b
    }

    // Function to swap two elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
