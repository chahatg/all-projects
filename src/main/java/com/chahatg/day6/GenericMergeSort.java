package com.chahatg.day6;
import java.util.Arrays;

//6. Implement generic version of the merge sorting 

public class GenericMergeSort<T extends Comparable<T>> {
	public static void main(String[] args) {
		Integer[] arr = {100,0,33,52,65,77,81,94,333,643,53};
        System.out.println(java.util.Arrays.toString(arr));
		GenericMergeSort<Integer> genMergeSorting = new GenericMergeSort<Integer>();
		genMergeSorting.mergeSort(arr, 0, arr.length - 1);
        System.out.println(java.util.Arrays.toString(arr));

	}
	
	void mergeSort(T[] array, int start, int end)
    {
        if (start < end)
        {
            int mid = (start + end) / 2;

            mergeSort(array, start, mid); // sort first half
            mergeSort(array, mid + 1, end);  // sort second half

            // merge the sorted halves
            merge(array, start, mid, end);
        }
    }
	
	void merge(T[] array, int start, int mid, int end) {
		T[] leftArr = (T[]) new Comparable[mid - start + 1];
	    T[] rightArr = (T[]) new Comparable[end - mid];

	    for (int i = 0; i < leftArr.length; ++i)
	    	leftArr[i] = array[start + i];

	    for (int i = 0; i < rightArr.length; ++i)
	        rightArr[i] = array[mid + 1 + i];

	    int lIdx= 0, rIdx = 0;
	    int currentIdx = start;

	        // compare each index of the subarrays adding the lowest value to the currentIndex
	    while (lIdx < leftArr.length && rIdx < rightArr.length) {
	    	if (leftArr[lIdx].compareTo(rightArr[rIdx]) <= 0) {
	    		array[currentIdx] = leftArr[lIdx];
	            lIdx++;
	        }
	        else {
	        	array[currentIdx] = rightArr[rIdx];
	            rIdx++;
	        }
	        currentIdx++;
	    }

	        // copy remaining elements of leftArray[] if any
	    while (lIdx < leftArr.length) array[currentIdx++] = leftArr[lIdx++];

	        // copy remaining elements of rightArray[] if any
	    while (rIdx < rightArr.length) array[currentIdx++] = rightArr[rIdx++];
	}
}
