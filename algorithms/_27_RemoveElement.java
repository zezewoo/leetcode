package algorithms;

/**
 * @author wxb
 * @date 2020-10-22 : 16:11
 */



public class _27_RemoveElement {


    public static void main(String[] args) {

        _27_RemoveElement removeElement = new _27_RemoveElement();

        int[] n1 = {3,2,2,3};
        int a = removeElement.removeElement(n1, 3);

    }


    public int removeElement(int[] nums, int val) {

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            } else {
                return 1;
            }
        }

        int bp = nums.length-1;
        int fp = 0;
        while (fp <= bp) {
            if (nums[bp] == val) {
                bp --;
                continue;
            }
            if (nums[fp] == val) {
                int tmp = nums[fp];
                nums[fp] = nums[bp];
                nums[bp] = tmp;
                bp --;
            }
            fp ++;
        }

        return nums.length - (nums.length-1-bp);
    }

}
