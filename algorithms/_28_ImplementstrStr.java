package algorithms;

/**
 * @author wxb
 * @date 2020-10-22 : 17:05
 */
public class _28_ImplementstrStr {


    public static void main(String[] args) {


        _28_ImplementstrStr str = new _28_ImplementstrStr();

        int a = str.strStr("a", "a");

    }



    public int strStr(String haystack, String needle) {

        if (needle == null || needle.length() == 0) {
            return 0;
        }

        if (haystack == null || haystack.length() == 0) {
            return -1;
        }

        for (int i=0;i<haystack.length()-needle.length()+1;i++) {
            int j =0, k =i;
            while (j<needle.length() && k<haystack.length()) {
                if (haystack.charAt(k) != needle.charAt(j)) {
                    j = needle.length() + 1;
                    break;
                }
                j++;k++;
            }
            if (j == needle.length()) {
                return i;
            }
        }

        return -1;

    }
}
