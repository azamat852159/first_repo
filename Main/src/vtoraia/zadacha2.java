package vtoraia;

import java.util.Scanner;

public class zadacha2 {
    int[] build = {1, 2, 3, 4, 5, 6};
    int[][] city = new int[6][6];

    public static void main(String[] args) {
        char[] chars = "000220000630040000440300".toCharArray();
        //new Scanner(System.in).next().toCharArray();
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ints[i] = chars[i] - 48;
        }
        chars = null;
        zadacha2 z = new zadacha2();
        z.rec(0, ints);


    }

    private void rec(int x, int[] ints) {
        boolean prov = false;
        int x1 = 0;                   //движение по билд
        for (int i = 0; i < build.length; i++) {
            city[(x - x%6)/6][x%6] = i;

        }
    }
}
