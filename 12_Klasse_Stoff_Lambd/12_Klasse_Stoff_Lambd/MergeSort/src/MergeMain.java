
public class MergeMain {

	// Divide-and-conquer => Merge
	public static void main(String[] args) {
		
		    int[] arr = { 60, 10, 20, 5, 60, 70 };
	        int n = arr.length;

	        System.out.println("Unsorted array:");
	        printArray(arr);

	        mergeSort(arr, 0, n - 1);

	        System.out.println("Sorted array:");
	        printArray(arr);

	}
	
    // Function to merge two subarrays of arr[]
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1; // Size of the first subarray
        int n2 = r - m;     // Size of the second subarray

        // Temporary arrays to hold the elements
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays L[] and R[]
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temporary arrays back into arr[l..r]
        int i = 0, j = 0;
        int k = l; // Initial index of the merged subarray

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of L[], if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy the remaining elements of R[], if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Function to implement merge sort
    public static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2; // Find the middle point

            // Recursively sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // Function to print the array
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
