package algorithms;


/**
 * @author buyi@gegejia.com
 * @date 2020-10-22 : 15:43
 */



public class _26_RemoveDuplicatesFromSortedArray {


    public static void main(String[] args) {

        _26_RemoveDuplicatesFromSortedArray sortedArray = new _26_RemoveDuplicatesFromSortedArray();


        int[] ia = {1,1,2};
        int a = sortedArray.removeDuplicates(ia);

        int[] ib = {0,0,1,1,1,2,2,3,3,4};
        int b = sortedArray.removeDuplicates(ib);

        int bc = sortedArray.removeDuplicates(ib);

    }


    public int removeDuplicates(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }
        int result = 1;
        int m = nums[0];
        int point = 1;

        for (int i=1;i<nums.length;i++) {

            if (nums[i] == m) {
                continue;
            } else {
                m = nums[i];
                nums[point] = m;
                point ++;
                result ++;
            }
        }

        return result;
    }
}
