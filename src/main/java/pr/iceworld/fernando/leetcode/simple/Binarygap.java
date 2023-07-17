package pr.iceworld.fernando.leetcode.simple;

import java.util.HashSet;
import java.util.Set;

public class Binarygap {

    public static void main(String[] args) {
        Binarygap binarygap = new Binarygap();
        System.out.println(binarygap.solution(32));
    }

    public int solution(int N) {
        Set<Integer> ll = new HashSet<>();
        // Implement your solution here
        int temp = 0;
        int loop = N / 15 + N % 4;
        int[] temps = new int[loop];
        boolean hasValue = false;
        boolean flag = false;
        while (loop > 0 && N > 1) {
            if ((N & 0x01) == 0x01) {
                flag = true;
            }
            while ((N & 0x01) != 0x01) {
                temp++;
                N = N >> 1;
            }
            if (temp > 0 && flag) {
                temps[loop - 1] = temp;
                hasValue = true;
            }
            loop = loop -1 - temp;
            temp = 0;
            if ((N & 0x01) == 0x01) {
                flag = true;
            } else {
                flag = false;
            }
            N = N >> 1;
        }

        temp = temps[0];
        if (hasValue) {
            for (int i = 1; i < temps.length; i++) {
                if (temp < temps[i]) {
                    temp = temps[i];
                }
            }
        }
        return temp;
    }
}
