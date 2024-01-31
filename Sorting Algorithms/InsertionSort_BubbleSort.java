package Lab2;
import java.util.*;


public class InsertionSort_BubbleSort {

	// method to swap two elements in a given array
	public static void swap(int[]a, int first, int second) {
		int temp=a[first];
		a[first]=a[second];
		a[second]=temp;
	}

	public static void insertionSortV1(int [] to_sort, int start) {
		// initialize start to 0

		int j = start+1;
		for (int i=start; j<to_sort.length;i++) {

			if (to_sort[i]>to_sort[j]) {
				
				swap(to_sort,i,j);
				
				for(int k=i-1;k>=0;k--) {
					
					if (to_sort[i]<to_sort[k]) {
						swap(to_sort,i,k);
					}
				}
			}
			j++;
		}
	}

	public static int findIndexMin(int [] array) {

		int index=1;

		for (int i=0; i<array.length;i++) {
			if (array[i]<array[index]) {
				index=i;
			}
		}
		return index;

	}


	public static void insertionSortV2(int [] to_sort) {

		int start = findIndexMin(to_sort);
		if (start!=0) // place minimum at the beginning
			for (int i=start;i>=1;i--) {
				swap(to_sort,i,i-1);
			}

		insertionSortV1(to_sort,1); // do insertion sort starting from the first element onward

	}

	public static void bubbleSort(int [] to_sort, int stop) {
		// stop is the index at which i stop looping initialized to 0
		
		int j=to_sort.length-1;
		for (int i=to_sort.length-1;j>=stop;i--) {
			
			if(to_sort[i]<to_sort[j]) {
				swap(to_sort,i,j);
			}
			
			j--;
		}
		
		stop++;
	}
	
	public static int [] randomArray(int size) {
		
		Random random = new Random();

		int [] array = new int[size];
	
		for (int i=0;i<size;i++) {
			array[i]=Math.abs(random.nextInt(100));
		}
	
		return array;
	}

	public static String printArray(int [] array) {
		String s="";
		for (int i=0;i<array.length;i++) {
			s+=" "+array[i];
		}
		return s;
	}

	public static void main (String [] args ) {
		
		int [] a1 = randomArray(10);
		int [] a2 = randomArray(100);
		int [] a3 = randomArray(500);
		
		System.out.println(printArray(a1));
		
		long startTime = System.nanoTime();
		insertionSortV1(a1,0);
		long endTime = System.nanoTime();
		long timeElapsed = endTime-startTime;
		System.out.println("Time elapsed for Insertion Sort version 1 for the 10 element array is "+timeElapsed);
		
		System.out.println(printArray(a1));
		
		long startTime1 = System.nanoTime();
		insertionSortV1(a2,0);
		long endTime1 = System.nanoTime();
		long timeElapsed1 = endTime1-startTime1;
		System.out.println("Time elapsed for Insertion Sort version 1 for the 100 element array is "+timeElapsed1);
		
		long startTime2 = System.nanoTime();
		insertionSortV1(a3,0);
		long endTime2 = System.nanoTime();
		long timeElapsed2 = endTime2-startTime2;
		System.out.println("Time elapsed for Insertion Sort version 1 for the 500 element array is "+timeElapsed2);
		
		int [] a4 = randomArray(10);
		int [] a5 = randomArray(100);
		int [] a6 = randomArray(500);

		System.out.println(printArray(a4));

		long startTime3 = System.nanoTime();
		insertionSortV2(a4);
		long endTime3 = System.nanoTime();
		long timeElapsed3 = endTime3-startTime3;
		System.out.println("Time elapsed for Insertion Sort version 2 for the 10 element array is "+timeElapsed3);
		
		System.out.println(printArray(a4));
		
		long startTime4 = System.nanoTime();
		insertionSortV2(a5);
		long endTime4 = System.nanoTime();
		long timeElapsed4 = endTime4-startTime4;
		System.out.println("Time elapsed for Insertion Sort version 2 for the 100 element array is "+timeElapsed4);
		
		
		long startTime5 = System.nanoTime();
		insertionSortV2(a6);
		long endTime5 = System.nanoTime();
		long timeElapsed5 = endTime5-startTime5;
		System.out.println("Time elapsed for Insertion Sort version 2 for the 500 element array is "+timeElapsed5);
		
		int [] a7 = randomArray(10);
		int [] a8 = randomArray(100);
		int [] a9 = randomArray(500);

		System.out.println(printArray(a7));

		long startTime6 = System.nanoTime();
		bubbleSort(a7,0);
		long endTime6 = System.nanoTime();
		long timeElapsed6 = endTime6-startTime6;
		System.out.println("Time elapsed for bubbleSort for the 10 element array is "+timeElapsed6);
		
		System.out.println(printArray(a7));
		
		long startTime7 = System.nanoTime();
		bubbleSort(a8,0);
		long endTime7 = System.nanoTime();
		long timeElapsed7 = endTime7-startTime7;
		System.out.println("Time elapsed for bubbleSort for the 100 element array is "+timeElapsed7);
		
		long startTime8 = System.nanoTime();
		bubbleSort(a9,0);
		long endTime8 = System.nanoTime();
		long timeElapsed8 = endTime8-startTime8;
		System.out.println("Time elapsed for bubbleSort for the 500 element array is "+timeElapsed8);
	}

}
