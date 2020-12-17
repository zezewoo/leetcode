package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wxb
 * @date 2020-11-04 : 11:41
 */
public class _46_Permutations {


    public static void main(String[] args) {


        _46_Permutations permutations = new _46_Permutations();

        int[] nums = {1, 2, 3};
        List<List<Integer>> a = permutations.permute(nums);
        List<List<Integer>> b = permutations.permute(nums);

    }



    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        recurse(nums, results, new ArrayList<>());
        return results;
    }



    public void recurse(int[] nums, List<List<Integer>> result, List<Integer> list) {

        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        }

        for (int i=0;i<nums.length;i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            recurse(nums, result, list);
            list.remove(list.size()-1);
        }
    }


    public List<List<Integer>> permute1(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            Integer integer = nums[i];
            list.add(integer);
        }

        List<List<Integer>> results = new ArrayList<>();

        if (nums.length == 1) {
            results.add(list);
            return results;
        }

        results = subPermute(list, 0, nums.length-1);
        return results;
    }



    public List<List<Integer>> subPermute(List<Integer> list, int start, int end) {

        List<List<Integer>> results = new ArrayList<>();
        if (start == end) {
            List<Integer> as = new ArrayList<>();
            as.add(list.get(start));
            results.add(as);
            return results;
        }

        int mid = (start+end)/2;

        List<List<Integer>> lefts = subPermute(list, start, mid);
        List<List<Integer>> rights = subPermute(list, mid+1, end);

        for (List<Integer> left : lefts) {
            for (List<Integer> right : rights) {
                List<Integer> match1 = new ArrayList<>();
                match1.addAll(left);
                match1.addAll(right);
                results.add(match1);

                List<Integer> match2 = new ArrayList<>();
                match2.addAll(right);
                match2.addAll(left);
                results.add(match2);
            }
        }

        return results;
    }

}
