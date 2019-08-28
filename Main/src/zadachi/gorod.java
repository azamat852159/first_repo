package zadachi;

import java.util.*;

public class gorod {
    List<List<Integer>> list = new ArrayList<>();
    List<variki> varikis = new ArrayList<>();
    public int[][] ints = new int[6][6];


    void createVariki() {                                                     //не сортировано по лукерам
        int x;
        int y;
        for (int i = 0; i < list.size(); i++) {
            varikis.add(new variki());
            x = list.get(i).get(0);
            y = list.get(i).get(5);
            for (int j = 0; j < 5; j++) {
                varikis.get(i).list.add(list.get(i).get(j));

                if (x < list.get(i).get(j + 1)) {
                    varikis.get(i).look.set(0, varikis.get(i).look.get(0) + 1);
                    x = list.get(i).get(j + 1);
                }

                if (y < list.get(i).get(4 - j)) {
                    varikis.get(i).look.set(1, varikis.get(i).look.get(1) + 1);
                    y = list.get(i).get(4 - j);
                }
            }
            varikis.get(i).list.add(list.get(i).get(5));
        }
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        char[] chars = "000220000630040000440300".toCharArray();
        int[] lookersInt = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            lookersInt[i] = chars[i] - 48;
        }
        gorod g = new gorod();
        g.createMap();
        g.createVariki();

        for (int i = 0; i <g.varikis.size() ; i++) {
            System.out.println(g.varikis.get(i));
        }
        // варики готовы , ниже надо че то с ними делать


        //ниже метод рекурсии




        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(g.ints[i][j] + " ");
            }
            System.out.println();
        }


        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

    private void rec(int[] ints,int x){
        for (int i = 0; i <varikis.size() ; i++) {

        }
    }



    void createMap() {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (j == i)
                    continue;
                for (int k = 0; k < 6; k++) {
                    if (k == i || k == j)
                        continue;
                    for (int l = 0; l < 6; l++) {
                        if (l == k || l == i || l == j)
                            continue;
                        for (int m = 0; m < 6; m++) {
                            if (m == k || m == l || m == j || m == i)
                                continue;
                            for (int n = 0; n < 6; n++) {
                                if (n == k || n == l || n == j || n == i || n == m)
                                    continue;
                                list.add(new ArrayList<>());
                                list.get(count).add(i + 1);
                                list.get(count).add(j + 1);
                                list.get(count).add(k + 1);
                                list.get(count).add(l + 1);
                                list.get(count).add(m + 1);
                                list.get(count).add(n + 1);
                                count++;
                            }
                        }
                    }
                }
            }
        }
    }
}

class variki {
    @Override
    public String toString() {
        return "variki{" +
                "look=" + look +
                ", list=" + list +
                '}';
    }


    List<Integer> look = new ArrayList<>(Arrays.asList(1, 1));           //0- лево/верх , 1-право/низ
    List<Integer> list = new ArrayList<>();
}