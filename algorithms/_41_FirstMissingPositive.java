package algorithms;

import java.util.Arrays;

/**
 * @author wxb
 * @date 2020-10-30 : 17:43
 */



public class _41_FirstMissingPositive {




    public static void main(String[] args) {
        _41_FirstMissingPositive positive = new _41_FirstMissingPositive();

        int[] nums = {4,1,2,3};

        int a = positive.firstMissingPositive(nums);
        int b = positive.firstMissingPositive(nums);

    }



    public int firstMissingPositive(int[] nums) {


        Arrays.sort(nums);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int size = 0;

        boolean skipMin = false;
        boolean skipMax = false;

        int preSkipMin = min;
        int afterSkipMin = min;
        int preSkipMax = max;
        int afterSkipMax = max;


        for(int i=0;i<nums.length;i++) {
            if (nums[i] > 0) {
                size++;
            }

            if (nums[i] <= min && nums[i] > 0) {
                if (min - nums[i] > 1) {
                    preSkipMin = min;
                    afterSkipMin = nums[i];
                    skipMin = true;
                }
                min = nums[i];
            }

            if (nums[i] >= max && nums[i] > 0) {
                if (nums[i] - max > 1) {
                    preSkipMax = max;
                    afterSkipMax = nums[i];
                    skipMax = true;
                }
                max = nums[i];
            }
        }

        if (min > 1) {
            return 1;
        }

        if (skipMin && (preSkipMin < Integer.MAX_VALUE)) {
            return afterSkipMin + 1;
        }

        if (skipMax && (preSkipMax > Integer.MIN_VALUE)) {
            return preSkipMax + 1;
        }

        return max + 1;
    }

}
