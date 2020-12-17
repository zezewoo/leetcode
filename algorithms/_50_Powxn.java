package algorithms;






/**
 * @author wxb
 * @date 2020-11-04 : 11:00
 */


public class _50_Powxn {


    public static void main(String[] args) {
        _50_Powxn powxn = new _50_Powxn();

        double a = powxn.myPow(2, -2147483648);
        double b = powxn.myPow(4, -3);
        double c = powxn.myPow(2, -2);
        double d = powxn.myPow(2, 3);
        double e = powxn.myPow(2, 3);

    }


    public double myPow(double x, int n) {

        long nn = n;

        if (x == 1) {
            return x;
        }

        if (nn == 0) {
            return 1;
        }

        boolean flag = false;
        if (nn < 0) {
            flag = true;
            nn = -nn;
        }

        double result = 1;

        while (nn > 1) {
            long n1 = nn&1;
            if (n1 == 1) {
                result *= x;
            }
            x *= x;
            nn = nn >> 1;
        }
        result *= x;

        if (flag) {
            result = (double) 1 / result;
        }
        return result;
    }

    public double calPow(double x, int n) {

        if (x == 1) {
            return x;
        }

        boolean flag = false;
        if (n < 0) {
            flag = true;
            n = -n;
        }

        double result = 1;

        for (int i = 0; i < n; i++) {
            result *= x;
        }

        if (flag) {
            result = (double) 1 / result;
        }
        return result;
    }
}