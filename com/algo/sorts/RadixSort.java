package com.algo.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RadixSort{

    public static void main(String[] args){

        int[] arr = {2,4,1,5,6,3};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr){
        List<Integer>[] buckets = new ArrayList[10];
        for(int i = 0; i< 10 ;i++){
            buckets[i] = new ArrayList<>();
        }

        int div = 1,index;
        while(true){
            for(int i=0; i < arr.length;i++){
                index = (arr[i] /div) % 10;
                buckets[index].add(arr[i]);
            }
            if(buckets[0].size() == arr.length){ break;}
            for(int i = 0,k=0;i < 10;i++){
                for(int val : buckets[i]){
                    arr[k++] = val;
                }
                buckets[i].clear();
            }
            div *= 10;
        }
    }
}
