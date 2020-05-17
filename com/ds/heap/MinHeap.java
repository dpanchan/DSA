package com.dsa;

import java.util.Arrays;

class MinHeap {
	public static void main(String[] args) {
		MinHeap mh = new MinHeap();
		mh.push(3);
		mh.push(5);
		mh.pop();
		mh.print();
	}

	int[] arr;
	int size;

	public MinHeap() {
		arr = new int[10];
	}

	private void print() {
		System.out.println(Arrays.toString(arr));
	}

	private void heapUp(int index) {
		// push
	}

	private void push(int e) {
		arr[size++] = e;
		heapUp(size);
	}

	private void heapDown(int idx) {
		// pop
		int lcidx = 2* idx + 1;
		int rcidx = 2* idx + 2;
		int p = arr[idx];
		
	}

	private Integer top() {
		if (arr.length == 0) {
			return null;
		}
		return arr[0];
	}

	private Integer pop() {
		if (arr.length == 0) {
			return null;
		}
		
		int top = top();

		arr[0] = arr[size - 1];
		arr[--size] = 0;
		Arrays.toString(arr);
		heapDown(0);
		return top;
	}
}