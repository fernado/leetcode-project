package pr.iceworld.fernando.leetcode.simple;

public class Simple_67 {
    public static void main(String[] args) {
        //"100"
        //"110010"
        System.out.println(addBinary("100", "110010"));
    }

    public static String addBinary(String a, String b) {
        if (a.length() > b.length()) {
            return cal(a, b);
        } else {
            return cal(b, a);
        }
    }

    private static String cal(String a, String b) {
        if (a.equals("0") && b.equals(a)) return "0";
        int aLen = a.length();
        int bLen = b.length();
        char[] chars = new char[aLen + 1];
        int c = bLen;
        char[] bchars = new char[aLen];
        for (int i = 0; i < aLen; i++) {
            bchars[i] = '0';
        }

        for (int i = 0; i < bLen; i++) {
            bchars[aLen - bLen + i] = b.charAt(i);
        }

        chars[0] = '0';
        int index = aLen;
        boolean bInc = false;
        for (int i = aLen - 1; i >= 0; ) {
            if (a.charAt(i) == bchars[i]) {
                if (a.charAt(i) == '0') {
                    if (bInc) {
                        chars[index--] = '1';
                    } else {
                        chars[index--] = '0';
                    }
                    bInc = false;
                } else {
                    if (bInc) {
                        chars[index--] = '1';
                    } else {
                        chars[index--] = '0';
                    }
                    bInc = true;
                }
            } else {
                if (bInc) {
                    chars[index--] = '0';
                } else {
                    chars[index--] = '1';
                }
            }
            i--;
        }
        if (bInc) {
            chars[0] = '1';
            return new String(chars);
        }
        String res = new String(chars);
        return res.substring(1);


    }
}
