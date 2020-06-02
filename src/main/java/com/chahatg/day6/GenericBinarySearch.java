package com.chahatg.day6;
//5.  Implement a generic version of the binary search algorithm.
public class GenericBinarySearch<T> {
	public static void main(String[] args) {
		Character[] arr = {'a','b','c','d','e','f','g'};
		int index = search(arr, Character.valueOf('f'));
		System.out.println("Index of \'f\' is " + index);
	}
	
	public static <T extends Comparable<T>> int search( T[] arr, T item ) {
	      return search( arr, 0, arr.length-1, item);
	  }
	
	public static <T extends Comparable<T>> int search(T[] array, int l, int r, T val) 
	    { 
		 if ( val == null )
			 return -1;
		
		 if( l > r)
			 return -1;
		 
		 int mid = l+(r-l)/2;
		 
		 if( val.compareTo( array[mid] ) > 0 )
			 return search(array, mid+1, r, val);
		 else if( val.compareTo( array[mid] ) < 0 )
			 return search( array, l, mid-1, val);
		 else
			 return mid;
	    }

	
}
