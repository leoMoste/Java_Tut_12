package _MergeSortAlgorithminJava;

import java.util.Iterator;
import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {
		Random random = new Random();
		int[] numbers = new int[10];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(1000000);
		}
		
		System.out.println("Before");
		printArray(numbers);
		
		MergeSort(numbers);
		
		System.out.println("After");
		printArray(numbers);

	}

	private static void MergeSort(int[] numbers) {
		
		
	}

	private static void printArray(int[] numbers) {
		
		
	}

}
