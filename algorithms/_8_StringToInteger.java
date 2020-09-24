package algorithms;


import java.util.Arrays;
import java.util.List;

/**
 *  Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 *
 * Input: "42"
 * Output: 42
 * Example 2:
 *
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 *
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 *
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 *
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
 *
 *
 *
 *
 *
 * @author wuxiaobiao
 * @date 2020-09-24 : 10:42
 */
public class _8_StringToInteger {


    /**
     *   Runtime: 5 ms, faster than 20.60% of Java online submissions for String to Integer (atoi).
     * Memory Usage: 39.2 MB, less than 94.04% of Java online submissions for String to Integer (atoi).
     *
     *
     */

    public static void main(String[] args) {

        _8_StringToInteger integer = new _8_StringToInteger();

        int a = integer.myAtoi("-   234");
        int b = integer.myAtoi("4193 with words");
    }

    static List<Character> numbers = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
    static List<Character> pos = Arrays.asList('-', '+');


    public int myAtoi(String str) {

        if (str == null) {
            return 0;
        }
        if ("-".equals(str)) {
            return 0;
        }
        if ("+".equals(str)) {
            return 0;
        }

        if (str.length() == 0) {
            return 0;
        }

        int i = 0;

        while (i < str.length()) {
            if (i >= 1 && str.charAt(i) == ' ' && str.charAt(i-1) !=  ' ') {
                break;
            }
            i ++;
        }
        str = str.substring(0, i);
        str = str.replace(" ", "");


        i = 0;
        while (i < str.length()) {
            if (i >= 1 && !numbers.contains(str.charAt(i))) {
                break;
            } else if (i < 1 && !numbers.contains(str.charAt(i)) && !pos.contains(str.charAt(i))) {
                return 0;
            }
            i ++;
        }
        str = str.substring(0, i);
        if (str.length() == 0) {
            return 0;
        }

        if ("-".equals(str)) {
            return 0;
        }
        if ("+".equals(str)) {
            return 0;
        }

        String subString = str.substring(1, str.length());
        if (subString.contains("-") || subString.contains("+")) {
            return 0;
        }

        try {
            Integer result = Integer.valueOf(str);
            return result;
        } catch (Exception e) {

            if (str.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

}
