package example.day01._1어노테이션;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

class SuperClass { // 상위 클래스 // 부모
    public void method1(){}
}

class Subclass extends SuperClass{ // 하위클래스 // 자식

    @Override // 부모 클래스의 메소드를 재정의(내부코드 수정)한다 .. 부모클래스를 재정의 한다는걸 알림
    public void method1() {
        super.method1();
    }

    @Deprecated // 더이상 사용하지 않는 코드임을 알림
    public void method2() {

    }
}

// [1] 어노테이션 만들기
@Retention(RetentionPolicy.RUNTIME) // 런타임까지 유지한다는 뜻
@Target(ElementType.METHOD) // 해당 어노테이션은 메소드에만 적용한다는 뜻
@interface Annotation1 {
    // 추상메소드
    String value1();
}

// [2] 어노테이션 사용하기
class TestClass{
    @Annotation1(value1 ="value1에 값 저장")
    public void method3(){
        // value1이라는 값을 사용할 수 있다.(내부적으로)
        // System.out.println(value1);
    }
}

public class Example1 {
    public static void main(String[] args) {
    Subclass subclass = new Subclass();
        subclass.method1(); // 오버라이딩된 메소드
        subclass.method2(); // 비권장(더이상 사용하지 않는) 메소드
        // [3] 리플렉션된 클래스 정보 확인
        try {
            Method method = TestClass.class.getMethod("method3");
            Annotation1 annotation = method.getAnnotation(Annotation1.class);
            System.out.println(annotation.value1());
        } catch (Exception e) {System.out.printf(e.getMessage());}
    }
}
/*
    [1] 인텔리제이 자동 완성(대소문자 구별)
        1. 자동완성할 문자 몇개 입력하면 자동으로 아래에 여러가지 추천 코드 나온다.
        2. 본인이 자동완성할 코드를 키보드 방향키로 이동 후 엔터
     [2] TabNine 플러그인 자동완성(한글 지원X)
        1. 코드 작성후 엔터 치면 자동으로 추천 코드를 확인 후 tab 키
        2. ESC 누르면 취소
 */