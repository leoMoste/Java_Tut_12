
public class MainSorting {

	public static void main(String[] args) {
		int[] arr = {5, 2, 9, 1, 6};
		
		// Print unsorted array
        System.out.println("Unsorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        // Version 1)
        // Basic Insertion Sort (works fine but without performance considerations)
        for (int i = 1; i < arr.length; i++) { // Starting from the second element
            int key = arr[i];                  // The current element to be inserted
            int j = i - 1;                     // Start comparing with the previous element
            while (j >= 0 && arr[j] > key) {   // Compare and shift larger elements to the right
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;                  // Insert the key in the correct position
        }
        
        // Version 2)
        // Insertion Sort with separated comparison and insertion logic
        insertionSort(arr);

        // Print sorted array
        System.out.println("\nSorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

	}
	
	  // Separate insertion sort logic into a function
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            insertElement(arr, key, j);
        }
    }
    
 // Separate function to handle the insertion
    public static void insertElement(int[] arr, int key, int j) {
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]; // Shift elements
            j--;
        }
        arr[j + 1] = key;  // Insert the key in the correct position
    }

}
