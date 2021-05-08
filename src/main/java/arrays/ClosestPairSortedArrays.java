package arrays;


/**Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each array.
        We are given two arrays ar1[0…m-1] and ar2[0..n-1] and a number x, we need to find the pair ar1[i] + ar2[j] such that absolute value of (ar1[i] + ar2[j] – x) is minimum.
        Example:

        Input:  ar1[] = {1, 4, 5, 7};
        ar2[] = {10, 20, 30, 40};
        x = 32
        Output:  1 and 30

        Input:  ar1[] = {1, 4, 5, 7};
        ar2[] = {10, 20, 30, 40};
        x = 50
        Output:  7 and 40*/
public class ClosestPairSortedArrays {

    private void printClosest(int[] ar1, int[] ar2, int m, int n, int x) {
        int l_res = 0, r_res = 0;
        int l = 0, r = n-1;
        int diff = Integer.MAX_VALUE;

        while (l < m && r >=0) {
            if (ar1[l] + ar2[r] - x < diff) {
                l_res = l;
                r_res = r;
                diff = Math.abs(ar1[l] + ar2[r] - x);
            }
            if (ar1[l] + ar2[r] > x)
                r--;
            else
                l++;
        }
        System.out.println("The closest pair is [" + ar1[l_res] +
                ", " + ar2[r_res] + "]");
    }

    public static void main(String[] args)
    {
        ClosestPairSortedArrays ob = new ClosestPairSortedArrays();
        int[] ar1 = {1, 4, 5, 7};
        int[] ar2 = {10, 20, 30, 40};
        int m = ar1.length;
        int n = ar2.length;
        int x = 38;

        ob.printClosest(ar1, ar2, m, n, x);
    }
}
