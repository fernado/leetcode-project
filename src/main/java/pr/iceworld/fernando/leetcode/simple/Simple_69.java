package pr.iceworld.fernando.leetcode.simple;

/**
 * refer to simple_69
 */
public class Simple_69 {

    public static void main(String[] args) {
        System.out.println(mySqrt(16));
    }

    public static int mySqrt(int x) {
        if (x == 1)
            return 1;
        int i = 0;
        int j = x;
        while (j - i > 1) {
            int temp = (i + j) / 2;
            if (x / temp < temp)
                j = temp;
            else
                i = temp;
        }
        return i;


        //if (x == 1 || x == 2 || x == 3) {
        //    return 1;
        //}
        //int a = 1;
        //int p;
        //do {
        //    a = (x / a + a) / 2;
        //    p = a * a - x;
        //} while((p >= 0 ? p : -p) > 0);
        //return a;
    }
}
