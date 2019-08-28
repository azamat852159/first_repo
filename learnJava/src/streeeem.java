import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streeeem {
    public static void main(String[] args) {
        List <Cat> list = new ArrayList<>();
        list.add(new Cat(4,"black"));
        list.add(new Cat(2,"white"));
        list.add(new Cat(5,"red"));
        list.add(new Cat(1,"green"));
        list.add(new Cat(3,"yellow"));

        list = list.stream().sorted((x,y)->x.age -y.age).collect(Collectors.toList());


    //    System.out.println(list);

  //  if(list.stream().max((z,y)->z.age -y.age).isPresent()){
  //      int x = list.stream().max((z,y)->z.age -y.age).get().age;
  //      System.out.println(x);
  //  }
        Cat newCat = new Cat(1,"asd"){
            @Override
            public void run() {
                System.out.println("yes");
            }
        };

       // Cat c = ()-> System.out.println("ad");

        dog d = (x)-> {System.out.println("asd");
        return 0;};


      //  list.stream().forEach(Cat::run);

       Object v = d.run1(1);

       System.out.println(v.hashCode());

    }
}

interface dog{
    int run1(int x) ;
}



class Cat {
    int age;
    String color;

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public Cat(int age, String color) {
        this.age = age;
        this.color = color;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void run(){
        System.out.println("no");
    }
}
