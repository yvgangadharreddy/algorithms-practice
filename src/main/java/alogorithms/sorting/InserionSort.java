package alogorithms.sorting;

public class InserionSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 6, 1, 4};
        insertionSort(arr);
        for (int j=0; j<arr.length; j++) {
            System.out.println(arr[j]);
        }
    }

    private static int[] insertionSort(int[] arr) {
        for (int j=1; j<arr.length; j++) {
            int key = arr[j];
            int i= j-1;
            while (i>=0 && arr[i] > key) {
                arr[i+1] = arr[i];
                i = i-1;
                arr[i+1] = key;
            }
        }
        return arr;
    }
}
