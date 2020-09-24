package algorithms;

/**
 *  Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 *
 *
 * @author wuxiaobiao
 * @date 2020-09-24 : 09:35
 */
public class _7_ReverseInteger {


    /**
     *
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Integer.
     * Memory Usage: 36.8 MB, less than 67.07% of Java online submissions for Reverse Integer.
     *
     */



    public static void main(String[] args) {

        _7_ReverseInteger reverseInteger = new _7_ReverseInteger();
        int a = reverseInteger.reverse(1534236469);
        int b = reverseInteger.reverse(-123);
    }



    public int reverse(int x) {

        long y = 0;

        int xx = x;
        int max = 0;

        while (xx > 0 || xx < 0) {
            xx = xx/10;
            max ++;
        }

        for (int i=1; i<=max; i++) {
            long w = (int)Math.pow(10, i-1);
            long k = (int)Math.pow(10, max-i);
            long t = x%(w*10);
            long z = t/w;
            y += z*k;
            if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int)y;
    }

}
