package example.day09;

import lombok.Builder;

import java.lang.reflect.Member;
@Builder
class MemberDto{
    private String name; // 멤버변수;
    private int age; // 멤버변수
    public MemberDto(String name, int age){
        this.name = name; // this : MemberDto 객체
        this.age = age; // this : MemberDto 객체
    }
}

public class Example1 {
    public static void main(String[] args) {
        // (1) MemberDto(객체) 생성할때 멤버변수에 초기값을 대입하는 방법(생성자)
        MemberDto memberDto0 = new MemberDto("유재석", 40);
        //MemberDto memberDto1 = new MemberDto(); // 존재하지않는 생성자 사용
        //MemberDto memberDto2 = new MemberDto("dbwotjr"); // 정의된 생성자가 없어서 // 정의된 생성자의 매개변수를 일치하지 않아서
        //MemberDto memberDto3 = new MemberDto(40, "유재석"); // 정의된 생성자의 매개변수를 일치하지 않아서
        //MemberDto memberDto4 = new MemberDto("유재석" , 40, "연예인"); // 정의된 생성자가 없어서 // 정의된 생성자의 매개변수를 일치하지 않아서

        // 생성자 규칙 :
        // 1. 정의(만든) 생성자만 사용이 가능하ㅏㄷ. 만든 생성자가 1개도 없을때는 기본 생성자가 자동으로 생성
        // 2. 매개변수 순서와 타입, 개수 일치해야한다.

        // 다양한 생성자를 사용하면 복잡도 올라간다. -> Builder Pattern
        // ! 빌더패턴 @Builder : 복잡한 객체 생성 과정을 단순화 해주는 디자인패턴
        // (2) 롬복 제공하는 @Builder 어노테이션 객체 생성
            // 클래스명.builder() : 빌더 객체를 생성
        MemberDto memberDto5 = MemberDto.builder().name("유재석").age(40).build();
        MemberDto memberDto6 = MemberDto.builder().build();
        MemberDto memberDto7 = MemberDto.builder().name("유재석").build();
        MemberDto memberDto8 = MemberDto.builder().age(40).name("유재석").build();
    }
}
