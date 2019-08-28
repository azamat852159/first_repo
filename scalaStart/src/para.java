import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class para {

    public static void main(String[] args) {
        List<Object>list = new ArrayList<>();
        list.add("asd");
        list.add(12);
        list.add(true);
        list.add(new cat());
        System.out.println(list);
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).hashCode());
        }
        String s = "123";
        String s1="1234";
        System.out.println(s+"4"==s1);
    }
}

class cat {
    int x = 2;
}

interface car{
    public void run();
}
