package com.algo.sorts;

import java.util.Arrays;

public class Merge {


    static void merge(int[] arr, int beg, int mid, int end, int maxele)
    {
        int i = beg;
        int j = mid + 1;
        int k = beg;
        while (i <= mid && j <= end)
        {
            if (arr[i] % maxele <= arr[j] % maxele)
            {
                arr[k] = arr[k] + (arr[i] % maxele) * maxele;
                k++;
                i++;
            }
            else
            {
                arr[k] = arr[k] + (arr[j] % maxele) * maxele;
                k++;
                j++;
            }
        }
        while (i <= mid)
        {
            arr[k] = arr[k] + (arr[i] % maxele) * maxele;
            k++;
            i++;
        }
        while (j <= end)
        {
            arr[k] = arr[k] + (arr[j] % maxele) * maxele;
            k++;
            j++;
        }
        for (i = beg; i <= end; i++)
        {
            arr[i] = arr[i] / maxele;
            System.out.println("i:" +i+"value:"+ arr[i]);
        }
    }

    static void mergeSortRec(int[] arr, int beg, int end, int maxele)
    {
        if (beg < end)
        {
            int mid = (beg + end) / 2;
            mergeSortRec(arr, beg, mid, maxele);
            mergeSortRec(arr, mid + 1, end, maxele);
            merge(arr, beg, mid, end, maxele);
        }
    }

    static void mergeSort(int[] arr, int n)
    {
        int maxele = Arrays.stream(arr).max().getAsInt() + 1;
        mergeSortRec(arr, 0, n - 1, maxele);
        System.out.println(Arrays.toString(arr) + n +" " + maxele);
    }

    // Driver code
    public static void main(String[] args)
    {

        int[] arr = {4,2,5,1,0,6};
        int n = arr.length;

        mergeSort(arr, n);

        System.out.println("Sorted array "+Arrays.toString(arr));

    }
}
