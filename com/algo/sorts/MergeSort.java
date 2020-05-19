package com.algo.sorts;

import java.util.Arrays;

class MergeSort{

    public static void main(String[] args) {
        int[] arr = {1,4,2,5,6,3,-1};
        System.out.println(Arrays.toString(ms(arr)));
    }

    public static int[] ms(int[] a) {
        return msh(a, 0, a.length-1);
    }

    private static int[] msh(int[] a, int i, int j) {
        if (i == j) {
            return new int[]{a[i]};
        }
        int mid = (i + j) / 2;
        var l = msh(a, i, mid);
        var r = msh(a, mid+1, j);
        return merge(l, r);
    }

    private static int[] merge(int[] l, int[] r) {
        int i = 0, j = 0, k = 0, m = l.length, n = r.length;
        int[] c = new int[m+n];
        while(i < m && j < n){
            if (l[i] < r[j]) {
                c[k++] = l[i++];
            } else {
                c[k++] = r[j++];
            }
        }

        k = extend(c, k, l, i);
        k = extend(c, k , r, j);
        return c;
    }

    private static int extend(int[] c, int k, int[] l, int i) {
        while (i < l.length) {
            c[k++] = l[i];
            i++;
        }
        return k;
    }
}