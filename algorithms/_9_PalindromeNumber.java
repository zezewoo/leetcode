package algorithms;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 *
 *
 *
 * @author wuxiaobiao
 * @date 2020-09-24 : 14:25
 */
public class _9_PalindromeNumber {


    /**
     *   Runtime: 16 ms, faster than 14.83% of Java online submissions for Palindrome Number.
     * Memory Usage: 41.4 MB, less than 22.85% of Java online submissions for Palindrome Number.
     *
     *
     */

    public static void main(String[] args) {

        _9_PalindromeNumber number = new _9_PalindromeNumber();
        boolean a = number.isPalindrome(1231321);
        boolean b = number.isPalindrome(1221);
    }

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int xx = x;
        int max = 0;
        while (xx > 0 || xx < 0) {
            xx = xx/10;
            max ++;
        }

        for (int i=1; i<=max/2; i++) {
            int z = (int)Math.pow(10, i-1);
            int w = (int)Math.pow(10, i);
            int k = (int)Math.pow(10, max-i);
            if (x%w/z != (x/k)%10) {
                return false;
            }
        }
        return true;
    }


}
