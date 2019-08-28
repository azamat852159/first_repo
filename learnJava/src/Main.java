import java.util.*;

public class Main {



    List<StringBuilder> arr1 = new ArrayList<>();

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        char[] chars = sc.next().toCharArray();

        long time1 = System.currentTimeMillis();

        List<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            arr.add(new ArrayList<>());
            arr.get(i).add(chars[i]-48);
        }


        Main zad = new Main();
        for (int i = 0; i < arr.size(); i++) {
            zad.man(arr.get(i));
        }

        System.out.println(arr);
        int x = arr.size() - 1;



        zad.createList(arr.size());



        zad.rec(arr, 0);
        zad.sas();



        System.out.println();
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);



    }

    private void createList(int i) {
        for (int j = 0; j < i; j++) {
            this.list.add(0);
        }
    }


    private void sas()  {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.arr1.size(); i++) {
            s.append(this.arr1.get(i).reverse());
            if(i!=this.arr1.size()-1){
                s.append(',');
            }
        }
        System.out.println(s);
    }

    List<Integer> list = new ArrayList<>();

    private void rec(List<ArrayList<Integer>> list, int x) {
        if (x <= list.size()-1) {
            for (int j = 0; j < list.get(x).size(); j++) {
                rec(list, x + 1);
                if (x != list.size()-1) {
                    while (
                            this.list.get(x) < this.list.get(x + 1)
                    ) {
                        this.arr1.get(
                                this.list.get(x)).append(
                                list.get(x).get(j));
                        this.list.add(x, this.list.get(x) + 1);
                        this.list.remove(x + 1);
                    }
                }
                if (x == list.size()-1) {
                    this.arr1.add(this.list.get(x), new StringBuilder());
                    this.arr1.get(this.list.get(x)).append(list.get(x).get(j));
                    this.list.add(x, this.list.get(x) + 1);
                    this.list.remove(x + 1);
                }
            }
        }
    }

    private void man(ArrayList<Integer> list) {
        if (1 == list.get(0)) {
            list.add(2);
            list.add(4);
        } else if (2 == (list.get(0))) {
            list.remove(0);
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(5);
        } else if (3 == (list.get(0))) {
            list.remove(0);
            list.add(2);
            list.add(3);
            list.add(6);
        } else if (4 == (list.get(0))) {
            list.remove(0);
            list.add(1);
            list.add(4);
            list.add(5);
            list.add(7);
        } else if (5 == (list.get(0))) {
            list.remove(0);
            list.add(2);
            list.add(4);
            list.add(5);
            list.add(6);
            list.add(8);
        } else if (6 == (list.get(0))) {
            list.remove(0);
            list.add(3);
            list.add(5);
            list.add(6);
            list.add(9);
        } else if (7 == (list.get(0))) {
            list.remove(0);
            list.add(4);
            list.add(7);
            list.add(8);
        } else if (8 == (list.get(0))) {
            list.remove(0);
            list.add(0);
            list.add(5);
            list.add(7);
            list.add(8);
            list.add(9);
        } else if (9 == (list.get(0))) {
            list.remove(0);
            list.add(6);
            list.add(8);
            list.add(9);
        } else if (0 == (list.get(0))) {
            list.add(0);
            list.add(8);
        }
    }
}
