package com.algo.sorts;

import java.util.Arrays;

public class Heapi {

    public static void main(String[] args) {
        int[] arr = new int[]{5,-1,-4,3,-33};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;
        for(int i = n/2 -1 ; i >= 0; i--){
            heapify(arr, n, i);
        }
        for(int i = n-1; i> 0;i--){
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr,i,0);
        }

    }

    private static void heapify(int[] arr, int n, int i) {

        int smallest = i;
        int left = 2 *i +1, right = 2 * i +2;
        if(left < n && arr[left] < arr[smallest]) smallest = left;
        if(right < n && arr[right] < arr[smallest]) smallest = right;
        if(smallest != i){
            int tmp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = tmp;
            heapify(arr,n,smallest);
        }
    }

}
