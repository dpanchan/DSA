package com.algo.sorts;

import java.util.Arrays;

class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 2, -1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr) {
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i = 0;i< arr.length-1; i++){
                if(arr[i] > arr[i+1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    flag = true;
                }
            }
        }
    }
}
