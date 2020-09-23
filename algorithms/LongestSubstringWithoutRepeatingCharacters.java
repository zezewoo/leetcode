package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuxiaobiao
 * @date 2020-09-23 : 16:01
 */
public class LongestSubstringWithoutRepeatingCharacters {


    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        int ca = solution.lengthOfLongestSubstring(" ");
        int a = solution.lengthOfLongestSubstring("abcabcbb");
        int b = solution.lengthOfLongestSubstring("bbbbb");
        int c = solution.lengthOfLongestSubstring("pwwkew");

    }


    public int lengthOfLongestSubstring(String s) {

        if (s == null || "".equals(s)) {
            return 0;
        }

        Map<Integer, List<Character>> arr = new HashMap<>();

        int i = 0;
        int len = s.length();

        while(i <= len -1) {
            int j = i + 1;
            List<Character> list = new ArrayList<>();
            list.add(s.charAt(i));

            while (j <= len -1) {
                if (list.contains(s.charAt(j))) {
                    break;
                }
                list.add(s.charAt(j));
                j ++;
            }
            arr.put(i, list);
            i ++;
        }

        int max = 0;


        for (Map.Entry<Integer, List<Character>> entry: arr.entrySet()) {
            int l = entry.getValue().size();
            if (l > max) {
                max = l;
            }
        }
        return max;
    }

}
