package algorithms;

/**
 * @author buyi@gegejia.com
 * @date 2020-09-23 : 16:16
 */
public class MedianOfTwoSortedArrays {


    public static void main(String[] args) {

        MedianOfTwoSortedArrays sortedArrays = new MedianOfTwoSortedArrays();

        int[] nums1 = {10};
        int[] nums2 = {2, 3};
        double a = sortedArrays.findMedianSortedArrays(nums1, nums2);
        double b = sortedArrays.findMedianSortedArrays(nums1, nums2);

    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int[] num3 = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i <= m || j <= n ) {

            if (i == m && j == n) {
                break;
            }

            if (i == m || m == 0) {
                num3[k] = nums2[j];
                j ++;
                k ++;
                continue;
            }

            if (j == n || n == 0 ) {
                num3[k] = nums1[i];
                i ++;
                k ++;
                continue;
            }

            if (nums1[i] <= nums2[j]) {
                num3[k] = nums1[i];
                i ++;
            } else {
                num3[k] = nums2[j];
                j ++;
            }
            k ++;
        }

        int total = m + n;
        double result;
        if((total) %2 == 0) {
            result = ((double) num3[total/2 - 1] + (double) num3[total/2])  / 2;
        } else {
            result = num3[total/2];
        }
        return result;
    }


}
