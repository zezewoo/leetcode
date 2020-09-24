package algorithms;

/**
 * @author wuxiaobiao
 * @date 2020-09-23 : 19:37
 */
public class _6_ZigZagConversion {




    public static void main(String[] args) {


        _6_ZigZagConversion conversion = new _6_ZigZagConversion();
//        String a = conversion.convert("PAYPALISHIRING", 3);
        String b = conversion.convert("AB", 1);
        String c = conversion.convert("PAYPALISHIRING", 5);

    }



    public String convert(String s, int numRows) {

        String result = new String();

        int length = s.length();
        if (numRows == 1) {
            return s;
        }

        for (int i=0;i<numRows;i++) {

            int gap = 0;
            if (i > 0 && i < numRows -1) {
                gap = (numRows - 1 - i) * 2 ;
            }
            int j = i;
            while (j < length) {
                result += s.charAt(j);
                if (j + gap < length) {
                    if (gap > 0) {
                        result += s.charAt(j + gap);
                    }
                }
                j += (numRows - 1) * 2;
            }
        }

        System.out.println(result);
        return  result;

    }






}
