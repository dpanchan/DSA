import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Prac1 {
    public static int[] arr = {129, 39, -2, 800, 54};
    public static int n = arr.length;
    public static void main(String[] args) {
        count(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void count(int[] arr) {
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        for(int element : arr){
            if(element > maxVal) {
                maxVal = element;
            }if(element < minVal) {
                minVal = element;
            }
        }
        int[] countArray = new int[maxVal - minVal + 1];
        for(int element : arr){
            countArray[element - minVal] += 1 ;
        }
        for(int i =0, j=0; i < countArray.length;i++){
            for (int k=0; k < countArray[i];k++){
                arr[j++] = i + minVal;
            }
        }
    }
    private static void radixSort(int[] arr) {
        List<Integer>[] buckets = new ArrayList[10];//10 because 10 slots
        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<>();
        }
        int div = 1, index;
        while (true) {
            for (int i = 0; i < n; i++) {
                index = (arr[i] / div) % 10;
                buckets[index].add(arr[i]);
            }
            if (buckets[0].size() == n) {
                break;
            }
            for (int i = 0, k = 0; i < 10; i++) {
                for (int each : buckets[i]) {
                    arr[k++] = each;
                }
                buckets[i].clear();
            }
            div *= 10;
        }
    }
    private static void quick(int[] arr) {
        quickSort(arr, 0, n-1);
    }
    private static void quickSort(int[] arr, int less, int great) {
        if(less >= great) {
            return;
        }
        int l = less + 1, r = great;
        int pivot = arr[less];
        while(true) {
            while (l <= r && arr[l] <= pivot) l++;
            while (l <= r && arr[r] > pivot) r--;
            if (l >= r) {
                break;
            }
            if (arr[l] > arr[r]) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
            }
        }
        arr[less] = arr[r];
        arr[r] = pivot;
        quickSort(arr,less, r-1);
        quickSort(arr,r+1, great);
    }
    private static void bubble(int[] arr) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < n-1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i+1] = tmp;
                    swapped = true;
                }
            }
        }
    }
    private static void selection(int[] arr){
        for(int i =0;i<n;i++){
            int key = i;
            for(int j = i+1; j<n;j++){
                if(arr[j] < arr[key]){
                    key = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[key];
            arr[key] = tmp;
        }
    }
    private static void insertion(int[] arr){
        for(int i = 1; i<n;i++){
            int val = arr[i];
            int j = i-1;
            while(j>=0 && arr[j] > val){
                arr[j+1] = arr[j--];
            }
            arr[j+1] =val;
        }
    }
    private static void merger(int[] arr){
        if(n < 2){ return; }
        int mid = n /2 ;
        int[] less = new int[mid];
        int[] great = new int[n-mid];
        System.arraycopy(arr,0,less,0,mid);
        System.arraycopy(arr,mid,great,0,n-mid);
        merger(less);
        merger(great);
        merge(arr,less,great);
    }
    private static void merge(int[] arr, int[] less, int[] great) {
        int i = 0, j= 0, k = 0;
        while(i < less.length && j < great.length){
            if(less[i] < great[j]){
                arr[k++] = less[i++];
            }
            else{
                arr[k++] = great[j++];
            }
        }
        while(i < less.length ){
            arr[k++] = less[i++];
        }
        while(j < great.length){
            arr[k++] = great[j++];
        }
    }

}
