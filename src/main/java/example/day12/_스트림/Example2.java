package example.day12._스트림;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Example2 {
    public static void main(String[] args) {

        // 임의의 리스트 , List.of(초기값1, 초기값2, 초기값3, ~~~)
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            // < > : 제네릭타입 , 클래스 또는 이넡페이스 타입 내 전달하는 타입, 기본타입 지원 안됨
                // ---> int(기본타입) vs Integer(참조타입/래퍼클래스) : 기본타입 8개를 클래스로 사용할때.
            // List(인터페이스/추상) vs ArrayList/Vector(클래스)

        // 1. 컬렉션 프레임워크는 스트림 제공     리스트.stream().forEach()
        numbers.stream() // 스트림 생성
                .forEach(x -> System.out.println(x));

        // 2. .stream().map()
        List<Integer> result2 = numbers.stream() // 스트림 생성
                            .map(x -> x * 2) // map
                            .collect(Collectors.toList());
        System.out.println(result2);

        // 3. .stream().map.forEach()
        numbers.stream() // 1. numbers 에 데이터 하나씩 이동하는 데이터 통로 생성
                .map(x -> x * 2) // 2. 데이터 통로를 이동하면서 데이터를 중간 연산
                .forEach(x -> System.out.println(x)); // 3. 데이터 통로의 끝에 데이터 결과를 출력

        // 4. .stream().filter.forEach()
        numbers.stream()
                .filter(x -> x % 2 == 0) // 짝수만 필터하기 // if 역할
                .forEach(x -> System.out.println(x)); // filter된 결과를 출력
                // vs
        for(int index = 0; index <= numbers.size()-1; index++){
            if(numbers.get(index) % 2 == 0){
                System.out.println(numbers.get(index));
            }
        }
        // 5. numbers.stream().sorted().forEach(); : 오름차순 정렬
        // numbers.stream().sorted(Comparator.reverseOrder()).forEach(); : 내림차순 정렬
        numbers.stream()
                .sorted()
                .forEach(x -> System.out.println(x));

        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(x -> System.out.println(x));
    }
}
