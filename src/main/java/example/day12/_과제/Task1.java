package example.day12._과제;

import java.util.Comparator;
import java.util.List;

class Fruits{
    String x;
    public Fruits(){}
    public Fruits(String x){
        this.x = x;
    }
    public static void onMessage2( String message ){
        System.out.println( message );
    }
}

public class Task1 {
    public static void main(String[] args) {
        List<String> 과일들 = List.of("사과", "바나나", "체리", "대추", "포도");
        과일들.stream().forEach(x -> System.out.println(x));
        과일들.stream().map(x -> x).forEach(x -> System.out.println(x));
        과일들.stream().filter(x -> x.equals("바나나") || x.equals("대추")).forEach(x -> System.out.println(x));
        과일들.stream().sorted(Comparator.reverseOrder()).forEach(x -> System.out.println(x));
//        과일들.forEach((x) -> {new Fruits(x);});
//        과일들.forEach(Fruits::new);
//        과일들.forEach((x) -> {Fruits.onMessage2(x);});
        과일들.forEach(Fruits::onMessage2);
        과일들.stream().map(x -> x).forEach(Fruits::onMessage2);
        과일들.stream().filter(x -> x.equals("바나나") || x.equals("대추")).forEach(Fruits::onMessage2);
        과일들.stream().sorted(Comparator.reverseOrder()).forEach(Fruits::onMessage2);

    }
}
