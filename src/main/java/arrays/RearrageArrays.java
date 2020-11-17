/** Sort an array of integer into order given as
 a) Original Array -- [0,2,1,5,4,3]
 b) Output -- [0,5,1,4,2,3]



 First element should be smallest
 second element should be Largest
 third element should be 2nd smallest
 Fourth element should be 2nd largest
 ...

 NO copy of array to be created*/

package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RearrageArrays {

    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static void main(String a[]){
        int[] arr = {0, 2, 1, 5, 4, 3};
        sortArray(arr);//sorting array using selection sort
        System.out.println("After Selection Sort");
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    public static void sortArray(int[] arr){
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            if (i%2 == 0) {
                index = getSmallestNumberIndex(arr, i, index);
            } else {
                index = getLargestNumberIndex(arr, i, index);
            }

            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    private static int getLargestNumberIndex(int[] arr, int i, int index) {
        for (int j = i + 1; j < arr.length; j++){
            if (arr[j] > arr[index]){
                index = j;//searching for lowest index
            }
        }
        return index;
    }

    private static int getSmallestNumberIndex(int[] arr, int i, int index) {
        for (int j = i + 1; j < arr.length; j++){
            if (arr[j] < arr[index]){
                index = j;//searching for lowest index
            }
        }
        return index;
    }
}

class MultiplicationModular {

    // Prints max at first position, min at second
    // position second max at third position, second
    // min at fourth position and so on.
    public static void rearrange(int arr[], int n)
    {
        // initialize index of first minimum and first
        // maximum element
        int max_idx = n - 1, min_idx = 0;

        // store maximum element of array
        int max_elem = arr[n - 1] + 1;

        // traverse array elements
        for (int i = 0; i < n; i++) {
            // at even index : we have to put
            // maximum element
            if (i % 2 == 0) {
                arr[i] += (arr[max_idx] % max_elem) * max_elem;
                max_idx--;
            }

            // at odd index : we have to put minimum element
            else {
                arr[i] += (arr[min_idx] % max_elem) * max_elem;
                min_idx++;
            }
        }

        // array elements back to it's original form
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] / max_elem;
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int n = arr.length;

        System.out.println("Original Array");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        rearrange(arr, n);

        System.out.print("\nModified Array\n");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
