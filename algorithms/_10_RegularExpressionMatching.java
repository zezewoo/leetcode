package algorithms;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 *
 *
 *
 *
 * @author wuxiaobiao
 * @date 2020-09-24 : 14:45
 */
public class _10_RegularExpressionMatching {




    public static void main(String[] args) {

        _10_RegularExpressionMatching matching = new _10_RegularExpressionMatching();
//        boolean a = matching.isMatch("ab", ".*");
        boolean b = matching.isMatch("aab", "c*a*b");
        boolean c = matching.isMatch("mississippi", "mis*is*p*.");
    }



    static char star = '*';
    static char point = '.';

    public boolean isMatch(String s, String p) {

        int ls = s.length();
        int lp = p.length();

        if (ls > lp) {
            return false;
        }


        int i = 0;
        int j = 0;

        while (i < lp) {

            j = 0;
            while (j < ls && i + j < lp) {
                if (s.charAt(j) == p.charAt(i + j)) {
                    j ++;
                    continue;
                } else if (p.charAt(i + j) == point) {
                    j ++;
                    continue;
                } else if (p.charAt(i + j) == star) {
                    if (i + j >= 1) {
                        String subStr = p.substring(0, i + j);
                        String s1 = String.valueOf(s.charAt(j));
                        if (subStr.contains(s1)) {
                            j ++;
                            continue;
                        }
                    }
                }
                break;
            }
            if (j == ls) {
                return true;
            }
            i ++;
        }

        return false;
    }

}
