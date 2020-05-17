package com.algo.sorts;

import java.util.Arrays;

class SelectionSort{

    public static void main(String[] args) {
        int[] arr = {7,3,2,6,1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i<n-1; i++){
            int mini = i;
            for(int j= i+1; j<n; j++){
                if(arr[j] < arr[mini]){
                    mini = j;
                }
            }
            int tmp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = tmp;
        }

    }
}