
public class Main {

	public static void main(String[] args) {
		 int[] arr = { 64, 34, 25, 12, 22, 11, 90 };

	        System.out.println("Original array:");
	        for (int i : arr) {
	            System.out.print(i + " ");
	        }
	        System.out.println();

	        // Call the Insertion Sort function
	        insertionSort(arr);

	        System.out.println("\nSorted array:");
	        for (int i : arr) {
	            System.out.print(i + " ");
	        }

	}
	
	// Insertion Sort implementation using left and right concepts
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // The outer loop represents the right side of the array
        for (int right = 1; right < n; ++right) {
            int key = arr[right];  // The current element to be inserted
            int left = right - 1;  // Start with the last element in the left sorted part

            // Shift elements in the left (sorted part) to the right
            while (left >= 0 && arr[left] > key) {
                arr[left + 1] = arr[left];  // Shift the left element to the right
                left--;  // Move left to the previous element
            }

            // Insert the key element at the correct position in the left sorted part
            arr[left + 1] = key;
        }
    }

}
