package Assignment2;

public class QuickSort {

	public static void inPlaceQuickSort(int []a, int start1, int end1, int pivot, int start2, int end2) {

		if (end2-start1==1) { // when of size 2
			if (a[end2]<a[start1])
					swap(a,end2,start1);
		}
		
		if (end2-start2<=0||end1-start1<=0){
			return;
		}
			

		else {

			// swap elements 
			
			int left=start1;
			int right=pivot+1;

			while(left<pivot && right<=end2) {

				if(a[left]<=a[pivot]) {
					left++;
				}
				else {
					if(a[right]<=a[pivot]) {
						swap(a,left,right);
						left++;
						right++;
					}
					else {
						right++;
					}
				}
			}

			if (left<pivot) {	// shifting needs to take place
				// either left
				right=end2;
				// elements from left to pivot-1 need to be moved to the other side
				while(left<pivot) {

					if(a[left]>a[pivot]) {
						int temp=a[left];
						for(int i=end2;i>left;i--) 
							a[i-1]=a[i];

						a[end2]=temp;
						pivot--;
					}

					else {
						left++;
					}
				}
			}
			else if(right<=end2) { // or right side

				left=pivot-1;

				while(right<=end2) {

					if(a[right]<=a[pivot]) {
						int temp=a[right];
						for(int i=right;i>pivot;i--) 
							a[i]=a[i-1];

						a[pivot]=temp;
						right++;
						pivot++;

					}

				}
			}

			printArray(a);

			int start1_1=start1; 
			int end2_1= start1_1+left;

			int start1_2= pivot+1;	
			int end2_2= right;

			int pivot1=(start1_1+end2_1)/2;
			int pivot2=(start1_2+end2_2)/2;


			inPlaceQuickSort(a,start1_1,pivot1-1,pivot1,pivot1+1,end2_1);
			inPlaceQuickSort(a,start1_2,pivot2-1,pivot2,pivot2+1,end2_2);
		}

	}

	public static void swap(int[]a, int first, int second) {
		int temp=a[first];
		a[first]=a[second];
		a[second]=temp;
	}




	public static void printArray(int [] array) {
		String s="";
		for (int i=0;i<array.length;i++) {
			s+=" "+array[i];
		}
		System.out.println(s);
	}
	
	public static void main (String [] args) {
		
		int [] array = {2,3,5,6,1,2,3,4};
		inPlaceQuickSort(array,0,(array.length/2)-1,array.length/2,array.length+1,array.length-1);
	}


}
