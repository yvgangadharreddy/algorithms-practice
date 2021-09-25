package AlgoExpert.hard;

/**
 * Write a function that takes in an array of at least two integers and
 * that returns an array of the starting and ending indices of the smallest subarray in the input array
 * that needs to be sorted in place in order for the entire input array to be sorted (in ascending order).
 *
 * If the input array is already sorted, the function should return [-1, -1].
 *
 * Sample Input
 * array = [1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]
 * Sample Output
 * [3, 9]
 */

public class SubArraySort {
    public static int[] subarraySort(int[] array) {
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (isOutOfOrder(array, num, i)) {
                minOutOfOrder = Math.min(num, minOutOfOrder);
                maxOutOfOrder = Math.max(num, maxOutOfOrder);
            }
        }
        if(minOutOfOrder == Integer.MAX_VALUE){
            return new int[]{-1, -1};
        }
        int left = 0, right = array.length - 1;
        while (array[left] <= minOutOfOrder) left++;
        while (array[right] >= maxOutOfOrder) right--;
        return new int[] {left, right};
    }

    public static boolean isOutOfOrder(int[] arr, int num, int i) {
        if (i == 0) return num > arr[i+1];
        else if ( i == arr.length - 1) return num < arr[i-1];
        else return num > arr[i+1] || num < arr[i-1];
    }
}
