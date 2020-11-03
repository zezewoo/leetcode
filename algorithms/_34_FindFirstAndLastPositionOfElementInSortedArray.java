package algorithms;





/**
 * @author wxb
 * @date 2020-10-28 : 14:58
 */
public class _34_FindFirstAndLastPositionOfElementInSortedArray {


    public static void main(String[] args) {
        _34_FindFirstAndLastPositionOfElementInSortedArray sortedArray = new _34_FindFirstAndLastPositionOfElementInSortedArray();

        int[] nums = {1, 2, 3,3,3,4,4,4,4,4,4,5, 8,8,8, 9, 10};
        int[] a = sortedArray.searchRange(nums, 8);


        int[] nums1 = {3,5,7,9,10};
        int b = sortedArray.searchBinary(nums1, 8);
    }


    public int[] searchRange(int[] nums, int target) {
        return searchRangeBinary(nums, 0, nums.length-1, target);
    }


    public int[] searchRangeBinary(int[] nums, int start, int end, int target) {

        int[] res = new int[2];

        if (start > end) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        int mid = (start+end)/2;

        if (nums[mid] == target) {
            int i = mid;
            int j = mid;
            int a = i;
            int b = j;

            while (i>=start) {
                if (nums[i] == target) {
                    a = i;
                }
                i --;
            }
            res[0] = a;

            while (j<=end) {
                if (nums[j] == target) {
                    b = j;
                }
                j ++;
            }
            res[1] = b;
            return res;
        } else if (nums[mid] > target) {
            return searchRangeBinary(nums, start, mid-1, target);
        } else {
            return searchRangeBinary(nums, mid+1, end, target);
        }

    }


    public int searchBinary(int[] nums, int target) {
        return searchB(nums, 0, nums.length-1, target);
    }


    public int searchB(int[] nums, int start, int end, int target) {

//        if (start == end) {
//            if (nums[start] == target) {
//                return start;
//            } else if (nums[start] < target) {
//                return start+1;
//            } else if (nums[start] > target) {
//                return start;
//            }
//        }

        int mid = (start+end)/2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            if (start <= mid-1) {
                return searchB(nums, start, mid-1, target);
            } else {
                return mid;
            }
        } else {
            if (mid+1 <= end) {
                return searchB(nums, mid+1, end, target);
            } else {
                return mid+1;
            }
        }
    }

}
