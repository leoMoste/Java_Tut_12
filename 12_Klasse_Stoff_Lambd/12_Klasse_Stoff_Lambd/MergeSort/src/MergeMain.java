
public class MergeMain {

	// best use with Linked list DS
	// Divide-and-conquer => Merge
	public static void main(String[] args) {
		
		    int[] Mainarray = { 3, 7, 8, 5, 4 , 2, 6, 1};
	        int n = Mainarray.length;

	        System.out.println("Unsorted array:");
	        printArray(Mainarray);

	        mergeSort(Mainarray);

	        System.out.println("Sorted array:");
	        printArray(Mainarray);

	}
	
    private static void mergeSort(int[] mainArray) {
		
    	int length = mainArray.length;
    	
    	if(length <= 1) {
    		return; // base case
    	}
    	
    	int middle = length/2;  // 8/2 = 4
    	
    	// now create two new Sub-Array 
    	int[] leftArray = new int[middle]; // int[4] 
    	int[] rightArray = new int[length -  middle];  //  int[8 - 4] => int[4]
    	
    	// now we need to copy the elements of our 
    	// original mainArray to our left and right
    	int left = 0; // index for left array
    	int right = 0; // index for right array
    	// and like this we fill the two sub-Arrays
    	for(; left < length; left++) {
    		if(left < middle) {
    			leftArray[left] = mainArray[left];
    		}
    		else {
    			rightArray[right] = mainArray[left];
    			right++;
    		}
    	}
    	
    	mergeSort(leftArray);
    	mergeSort(rightArray);
    	merge(leftArray, rightArray, mainArray);
		
	}

	// Function to merge two subarrays of arr[]
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    private static void merge(int[] leftArray, int[] rightArray, int[] mainArray) {
		int leftSize = mainArray.length / 2;
		int rightSize = mainArray.length - leftSize;
		int index = 0, left = 0, right = 0; // indecies
		
		// check the condtions for merging
		while (index < leftSize && right < rightSize) {
			if(leftArray[left] < rightArray[right]) {
				mainArray[index] = leftArray[left];
				index++;
				left++;
			}
			else {
				mainArray[index] = rightArray[right];
				index++;
				right++;
			}
		}
		
		
		// there is going to be one element remaining that we cannot compare
		// to another element becuase there is only one left
		while (left < leftSize) {
			mainArray[index] = leftArray[left];
			index++;
			left++;
		}
		
		while (right < rightSize) {
			mainArray[index] = rightArray[right];
			index++;
			right++;
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
