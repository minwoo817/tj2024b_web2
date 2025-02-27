package example.day06._aop과제.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class StudentSecurity {
    // [*]  @Before / @AfterReturning 사용하지 않고 @Around 하나로 표현
    @Around( " execution( * example.day06._aop과제.service.StudentService.*(..) )" )
    public Object TaskServiceCheck( ProceedingJoinPoint joinPoint ) throws Throwable{
        // * 지정한 함수 시그너처 출력
        System.out.println("[실행메소드] : " + joinPoint.getSignature() );
        // 1. 매개변수 출력
        // Arrays.toString( 배열변수 ) : 배열 출력을 주소값이 아닌 값으로 반환
        System.out.println("[매개변수] : " + Arrays.toString( joinPoint.getArgs() ) );
        // * 지정한 함수 실행
        Object result = joinPoint.proceed();
        // 2. 반환 값 출력
        System.out.println("[반환값 ] : " + result );
        // * 지정한 함수의 반환 값 그대로 반환
        return result;
    }


}
/*
// [1] save, findAll 실행 전에 앞에 * : 모든리턴타입, 뒤에* : 모든 메소드, (..) : 모든 매개변수타입 , && args(매개변수명)
    @Before("execution(* example.day06._aop과제.service.StudentService.*(..) ) && args(param)")
    public void paramCheck(Object param) { // + Object ? 모든 매개변수들을 대입받기 위해서 (다형성) , 최상위 클래스
        System.out.println("[TaskService exe]");
        System.out.println("매개변수 : " + param);
    }
    // [2] save, findALl 실행 후에 , returning = "리턴값변수명"
    @AfterReturning(value = "execution( * example.day06._aop과제.service.StudentService.*(..) )", returning = "result" )
    public void returnCheck(Object result) { // + Object ? 모든 매개변수들을 대입받기 위해서 (다형성) , 최상위 클래스
        System.out.println("[TaskService return]");
        System.out.println("반환값 : " + result);
    }
    // [3] save, findAll 실행 전과 후 걸린 시간
    @Around("execution(* example.day06._aop과제.service.StudentService.*(..) )")
    public Object aroundCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        // ProceedingJoinPoint : AOP에서 사용되는 인터페이스
        // 제공하는 메소드
        // 1. proceed() : 지정한 메소드를 실행하는 메소드
        System.out.println(joinPoint.getArgs()); // 지정한 메소드의 매개변수 반환(배열타입)
        System.out.println(joinPoint.getSignature()); // 지정한 메소드 시그니처 반환(실행된 메소드의 리턴타입, 함수명, 매개변수)
        System.out.println(joinPoint.getTarget()); // 지정한 메소드를 실행한 객체(StudentService 객체)
        System.out.println(joinPoint.getThis()); // 지정한 메소드를 실행한 객체(StudentService 객체 + 프록시)
        // --> 추가 로직에서 직접 지정한 메소드 호출 : joinPoint.proceed(); , 예외처리 필수
        // (1) 시작 시간
        long startTime = System.currentTimeMillis(); // System.currentTimeMillis() : 현재 시간을 밀리초(1/1000초) 반환
        // (*) // 지정된 메소드( 'enter3' ) 실행
        Object result = joinPoint.proceed();
        // (2) 끝나는 시간
        long endTime = System.currentTimeMillis(); // 현재 시간을 밀리초(1/1000초) 반환
        // (3) 지정된 메소드가 실행했을때 걸린시간 계산
        long timeMs = endTime - startTime;
        // (4) 걸린시간 출력
        System.out.println("실행시간 : " + timeMs + " ms");
        // (5) 지정된 메소드가 리턴한 값 그대로 리턴
        return result;
    }
 */