package arrays;

public class FindMedian {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median;
        int[] temp = new int[nums1.length + nums2.length];
        int i=0, j=0, k=0;
        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                temp[k] = nums1[i];
                i++;
                k++;
            } else {
                temp[k] = nums2[j];
                j++;
                k++;
            }
        }

        while(i < nums1.length) {
            temp[k] = nums1[i];
            k++;
            i++;
        }

        while(j < nums2.length) {
            temp[k] = nums1[j];
            k++;
            j++;
        }
        int l = temp.length;
        if (l % 2 == 0) {
            median = (double) (temp[l/2 - 1] + temp[l/2])/2;
        } else {
            median = temp[l/2];
        }
        return median;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
