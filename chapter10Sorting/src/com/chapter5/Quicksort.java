package com.chapter5;

public class Quicksort {// Quicksort

	void quicksort(int[] array) {
		quicksort(array, 0, array.length - 1);
	}

	void quicksort(int[] array, int start, int end) {
		if (start >= end) return;
		int pivot = (start + end) / 2;
		int partitionIndex = partition(array, start, end, pivot);
		quicksort(array, start, partitionIndex-1);
		quicksort(array, partitionIndex, end);
	}

	int partition(int[] array, int start, int end, int pivot) {
		while (start <= end) {
			while (array[start] < pivot) {
				start++;
			}
			while (array[end] > pivot) {
				end--;
			}
			if (start <= end) {
				swap(array[start], array[end]);
				start++;
				end--;
			}
		}
		return start;
	}

	int swap(int i, int j){
		return j;
	}
}
