package algorithms;

/**
 * @author wxb
 * @date 2020-10-22 : 17:52
 */
public class _29_DivideTwoIntegers {


    public static void main(String[] args) {

        _29_DivideTwoIntegers divideTwoIntegers = new _29_DivideTwoIntegers();

        int a = divideTwoIntegers.divide(-2147483648, -1);
        int b = divideTwoIntegers.divide(-2147483648, -1);

    }



    public int divide(int dividend, int divisor) {

        if (dividend == 0) {
            return 0;
        }

        long dd = dividend;
        long dv = divisor;

        int pa = 1;
        int pb = 1;
        if (dd < 0) {
            dd = -dd;
            pa = 2;
        }

        if (dv < 0) {
            dv = -dv;
            pb = 2;
        }

        if (dd < dv) {
            return 0;
        }

        if (dv == 1) {

            if ((pa^pb)==3) {
                dd = -dd;
            }

            if (dd > Integer.MAX_VALUE) {
                dd = Integer.MAX_VALUE;
            } else if (dd < Integer.MIN_VALUE) {
                dd = Integer.MIN_VALUE;
            }
            return (int)dd;
        }

        long a = dv;
        long c = 1;

        while (dd >= a<<1) {
            a = a<<1;
            c = c<<1;
        }

        long b = dd - a;
        while (b >= dv) {
            b = b - dv;
            c += 1;
        }

        if (c > Integer.MAX_VALUE) {
            c = Integer.MAX_VALUE;
        } else if (c < Integer.MIN_VALUE) {
            c = Integer.MIN_VALUE;
        }
        return (pa^pb)==3?(int)-c:(int)c;
    }

}
