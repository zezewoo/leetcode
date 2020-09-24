package algorithms;


import java.util.Arrays;
import java.util.List;

/**
 * @author wuxiaobiao
 * @date 2020-09-24 : 10:42
 */
public class _8_StringToInteger {


    public static void main(String[] args) {

        _8_StringToInteger integer = new _8_StringToInteger();

        int a = integer.myAtoi("4193 with words");
        int b = integer.myAtoi("4193 with words");
    }


    static List<Character> numbers = Arrays.asList('-', '+', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    public int myAtoi(String str) {

        if (str == null) {
            return 0;
        }
        if ("-".equals(str)) {
            return 0;
        }

        str = str.replace(" ", "");
        if (str.length() == 0) {
            return 0;
        }

        if (!numbers.contains(str.charAt(0))) {
            return 0;
        }

        int i = 0;

        while (i < str.length()) {
            if (!numbers.contains(str.charAt(i))) {
                break;
            }
            i ++;
        }
        str = str.substring(0, i);

        String subString = str.substring(1, i);
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
