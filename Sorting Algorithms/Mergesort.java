package Lab3;

public class Mergesort {

	public void mergeOutPlace(int [] a, int s, int m, int e) {
		// a is my array, s is the beginning of the array and e the end = a.length - 1
		// m is the middle element
		//s1 is the beginning of the array on the left
		// s2 is the beginning of the array on the right

		int s2= m+1;
		int s1=s;
		int j=0;
		int [] aux = new int[e+1-s];

		while (s1<=m && s2<=e) {

			if (a[s1]<=a[s2]) {
				aux[j]=a[s1];
				j++;
				s1++;
			}
			else {
				aux[j]=a[s2];
				j++;
				s2++;
			}

		}

		if (s2==e && s1<=m) {
			while(s1<=m) {
				aux[j]=a[s1];
				s1++;
				j++;

			}
		}

		else if (s1==m && s2<=e) {
			while(s2<=e) {
				aux[j]=a[s2];
				s2++;
				j++;

			}
		}

		int count=0;
		for (int i=s;i<e;i++) {
			a[i]=aux[count];
			count++;
		}
	}

	public void mergeInPlace(int [] a,int s, int m, int e) {

		int s2=m+1;
		while(s<=m && s2<=e) {
			if (a[s]<=a[s2]) {
				s++;
			}
			else {
				int temp = a[s2];
				for(int i=s2;i>s;i--) { // very important!!!!! shifting the elements
					// taking the min element from a2 and putting it at the beginning
					
					a[i]=a[i-1];
				}
				a[s]=temp;
				s++;
				m++;
				s2++;
			}
		}
	}
	
	public void inPlace(int [] a, int s, int e) {
	// sort a starting at index s and ending at index e	
		if (e<s)
			return;
		else {
			int m=(s+e)/2;
			inPlace(a,s,m);
			inPlace(a,m+1,e);
			mergeInPlace(a,s,m,e);
			
			
		}
		
	}
	
	public void outPlace(int [] a,int s,int e) {
		
		if (e<s)
			return;
		else {
			int m=(s+e)/2;
			outPlace(a,s,m);
			outPlace(a,m+1,e);
			mergeOutPlace(a,s,m,e);
			
			
		}
		
		
	}


}



