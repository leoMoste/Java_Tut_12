
public class MainSort {
	
	  static void SelectionSortAsc(int[] arr)
	    {
	        int n = arr.length;

	        // One by one move boundary of unsorted subarray
	        for (int i = 0; i < n - 2; i++)
	        {
	            // Find the minimum element in unsorted array
	            int minIndex = i;
	            for (int j = i + 1; j < n; j++)
	                if (arr[j] < arr[minIndex])
	                    minIndex = j;

	            // Swap the found minimum element with the first element
	            int temp = arr[minIndex];
	            arr[minIndex] = arr[i];
	            arr[i] = temp;
	        }
	    }

	    static void SelectionSortDesc(int[] arr)
	    {
	        int n = arr.length;

	        // One by one move boundary of unsorted subarray
	        for (int i = 0; i < n - 1; i++)
	        {
	            // Find the Maximum element in unsorted array
	            int maxIndex = i;
	            for (int j = i + 1; j < n; j++)
	                if (arr[j] > arr[maxIndex])
	                    maxIndex = j;

	            // Swap the found minimum element with the first element
	            int temp = arr[maxIndex];
	            arr[maxIndex] = arr[i];
	            arr[i] = temp;
	        }
	    }
	

	public static void main(String[] args) {
	     int[] arr = { 64, 34, 25, 12, 22, 11, 90 };


	        System.out.println("Original array:");
	        for(int value : arr)
	        {
	        	 System.out.println(value + " ");
	        }
	        System.out.println();

	        SelectionSortAsc(arr);

	        System.out.println("\nSorted array ASC:");
	        for(int value : arr)
	        {
	        	 System.out.println(value + " ");
	        }

	        SelectionSortDesc(arr);

	        System.out.println("\n\nSorted array Desc:");
	        for(int value : arr)
	        {
	            System.out.println(value + " ");
	        }

	}

}
