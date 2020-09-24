package algorithms;


/**
 * @author wuxiaobiao
 * @date 2020-09-23 : 17:05
 */

public class _5_LongestPalindromicSubstring {


    public static void main(String[] args) {

        _5_LongestPalindromicSubstring substring = new _5_LongestPalindromicSubstring();
        String a = substring.longestPalindrome("1234asdadababa");
        String b = substring.longestPalindrome("abaaba");
        String c = substring.longestPalindrome("abab");
        String d = substring.longestPalindrome("a");

    }


    public String longestPalindrome(String s) {

        if (isPalindromicString(s)) {
            return s;
        }

        int length = s.length() - 1;
        while (length > 0) {
            int i = 0;
            while (i < s.length() && i + length <= s.length() ) {
                String sub = s.substring(i, i + length);
                if (isPalindromicString(sub)) {
                    return sub;
                }
                i++;
            }
            length--;
        }
        return null;
    }



    public boolean isPalindromicString(String string) {

        int length = string.length();

        if (length == 1) {
            return true;
        }

        int i = 0;
        while (i < length/2) {
            if (string.charAt(i) != string.charAt(length - 1 - i)) {
                return false;
            }
            i ++;
        }
        return true;
    }

}
