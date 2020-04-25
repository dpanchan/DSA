package com.dsa;

class BinarySearch{
	
	public static <E extends Comparable<E>> boolean binarySearch(E[] arr, E x, int left, int right) {
		int mid = left + ((right -left) /2); // memory integer overflow issues if right + left crosses range	
		if(left  > right ) {
			return false;
		}
		if(arr[mid].compareTo(x) == 0 ) {
			return true;
		}else if(arr[mid].compareTo(x) > 0) {
			return binarySearch(arr, x, left, mid -1);
		}else {
			return binarySearch(arr, x, mid + 1, right);
		}
	}
	
	public static <E extends Comparable<E>> boolean binarySearch(E[] arr, E x) {
		return binarySearch(arr, x, 0, arr.length -1); 
	}
	
	public static void main(String[] args) {		
		//Integer[] arr = {1,2,3,4,5};
		//int index = -57;
		
		
		String[] arr = {"hello","hai","Namaskaram","Vanakam"};
		String index = "hai";
		System.out.println(binarySearch(arr,index));
	}
}


