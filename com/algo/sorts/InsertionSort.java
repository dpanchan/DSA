package com.algo.sorts;

import java.util.Arrays;

class InsertionSort{
    public static void main(String[] args) {
        int[] arr = {1,8,2,3,2,5};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertionSort(int[] arr){
        for(int i = arr.length-1; i >= 0 ; i--){
            int key = arr[i];
            int j = i+1;
            while(j< arr.length && arr[j] < key){
                arr[j-1] = arr[j];
                j++;
            }
            arr[j-1] = key;
        }
    }
}