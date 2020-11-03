package algorithms;

import java.util.*;

/**
 * @author wxb
 * @date 2020-10-30 : 11:21
 */




public class _39_CombinationSum {


    public static void main(String[] args) {

        _39_CombinationSum sum = new _39_CombinationSum();

        int[] candidates = {2,3,5};

        List<List<Integer>> a = sum.combinationSum(candidates, 5);
        List<List<Integer>> b = sum.combinationSum(candidates, 15);
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> picks = new ArrayList();
        backtrack(candidates, 0, target, picks, result);
        return result;
    }

    private void backtrack(int[] cand, int start, int target, List<Integer> list, List<List<Integer>> result) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList(list));
            return;
        }
        for(int i = start; i < cand.length; i++) {
            list.add(cand[i]);
            backtrack(cand, i, target - cand[i], list, result);
            list.remove(list.size() - 1);
        }
    }

}
