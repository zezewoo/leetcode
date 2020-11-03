package algorithms;


/**
 * @author wxb
 * @date 2020-10-28 : 14:41
 */

public class _33_SearchInRotatedSortedArray {


    public int search(int[] nums, int target) {



        int i=0;
        int j = nums.length - 1;

        while (i <= j) {

            if (nums[i] == target) {
                return i;
            } else if (nums[j] == target) {
                return j;
            }
            i ++;
            j --;
        }

        return -1;
    }
}
