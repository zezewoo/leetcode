package algorithms;

import java.util.*;

/**
 * @author wxb
 * @date 2020-10-30 : 16:48
 */



public class _40_CombinationSumII {


    public static void main(String[] args) {

        int[] candidates = {10,1,2,7,6,1,5};

        _40_CombinationSumII  sumII = new _40_CombinationSumII();
        List<List<Integer>> a = sumII.combinationSum2(candidates, 8);
        List<List<Integer>> b = sumII.combinationSum2(candidates, 7);
    }



    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

//        Arrays.sort(candidates);
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> picks = new ArrayList<>();
        pick(candidates, 0, candidates.length-1, target, picks, result);
        return new ArrayList<>(result);
    }



    public void pick(int[] candidates, int start, int end, int target, List<Integer> picks, Set<List<Integer>> result) {

        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList(picks));
            return;
        }


        for(int i = start; i < candidates.length; i++) {
//            if (target-candidates[i] < 0) {
//                break;
//            }
            picks.add(candidates[i]);
            pick(candidates, i+1, end, target-candidates[i], picks, result);
            picks.remove(picks.size()-1);
        }
    }
}
