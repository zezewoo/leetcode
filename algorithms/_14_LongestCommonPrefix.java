package algorithms;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 *
 *
 *
 * @author wuxiaobiao
 * @date 2020-09-25 : 14:08
 */



public class _14_LongestCommonPrefix {


    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 37.2 MB, less than 96.73% of Java online submissions for Longest Common Prefix.
     *
     */

    public static void main(String[] args) {



        String[] strs = {"flower","flow","flight"};

        _14_LongestCommonPrefix prefix = new _14_LongestCommonPrefix();
        String a = prefix.longestCommonPrefix(strs);

        System.out.println(a);
    }



    public String longestCommonPrefix(String[] strs) {


        if (strs==null || strs.length == 0) {
            return "";
        }


        int max = Integer.MAX_VALUE;
        for (String str: strs) {
            int len = str.length();
            if (len < max){
                max = len;
            }
        }

        char result[] = new char[max];

        int i = 0;
        while (i < max) {
            for (String str: strs) {
                if (result[i] == 0) {
                    result[i] = str.charAt(i);
                } else if (result[i] != str.charAt(i)) {
                    return String.valueOf(result).substring(0, i);
                }
            }
            i++;
        }

        return String.valueOf(result);
    }


}
