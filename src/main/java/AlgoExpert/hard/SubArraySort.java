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
 *
 * Hint 1
 * Realize that even a single out-of-order number in the input array can call for a large subarray to have to be sorted. This is because, depending on how out-of-place the number is, it might need to be moved very far away from its original position in order to be in its sorted position.
 *
 * Hint 2
 * Find the smallest and largest numbers that are out of order in the input array. You should be able to do this in a single pass through the array.
 *
 * Hint 3
 * Once you've found the smallest and largest out-of-order numbers mentioned in Hint #2, find their final sorted positions in the array. This should give you the extremities of the smallest subarray that needs to be sorted.
 *
 * Optimal Space & Time Complexity
 * O(n) time | O(1) space - where n is the length of the input array
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
