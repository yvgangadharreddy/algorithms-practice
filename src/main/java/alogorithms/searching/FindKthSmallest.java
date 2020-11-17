package alogorithms.searching;

import java.lang.*;
import java.io.*;

class FindKthSmallest {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());
        while(testCases-- >0) {
            int size = Integer.parseInt(br.readLine().trim());
            String[] inputLine = br.readLine().trim().split(" ");
            int arr[] = new int[size];
            int k = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            if (k > size) {
                System.out.println("Index out of bound");
            } else {
                System.out.println(kthSmallest(arr, 0, size-1, k-1));
            }

        }
    }

    private static int kthSmallest(int[] arr, int low, int high, int k) {

        int pivot = partition(arr, low, high);
        if (pivot == k) {
            return arr[pivot];
        } else if (pivot < k){
            return kthSmallest(arr, pivot + 1, high, k);
        } else {
            return kthSmallest(arr, 0, pivot-1, k);
        }



    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], pivotLoc = low;
        for (int i = low; i <= high; i++) {
            if(arr[i] < pivot) {
                int temp = arr[pivotLoc];
                arr[pivotLoc] = arr[i];
                arr[i] = temp;
                pivotLoc++;
            }
        }

        int temp = arr[pivotLoc];
        arr[pivotLoc] = arr[high];
        arr[high] = temp;
        return pivotLoc;
    }
}

