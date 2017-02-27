package com.example.BinarySearch;

public class BinarySearch {
	 
    public boolean find(int[] sortedValues, int value) {
        return search(sortedValues, value, 0, sortedValues.length - 1);
    }
 
    private boolean search(int[] sorted, int value, int leftIndex, int rightIndex) {
 
        // 1. index check
        if (leftIndex > rightIndex) {
            return false;
        }
 
        // 2. middle index
        int middle = (rightIndex + leftIndex) / 2;
 
        // 3. recursive invoke
        if (sorted[middle] > value) {
            return search(sorted, value, leftIndex, middle - 1);
        } else if (sorted[middle] < value) {
            return search(sorted, value, middle + 1, rightIndex);
        } else {
            return true;
        }
    }
 
}
