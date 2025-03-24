package example.day10.멀티스레드;



// User1 클래스
class User1 extends Thread {
    public Calculator calculator;
    @Override
    public void run() {
        calculator.setMemory(100);
    }
}

// User2 클래스
class User2 extends Thread {
    public Calculator calculator;
    @Override
    public void run() {
        calculator.setMemory(200);
    }
}

// Calculator 클래스
class Calculator{
    public int memory; // 멤버변수
    public synchronized void setMemory(int memory){
        this.memory = memory;
        try {
            Thread.sleep(2000);
            // user1 스레드가 2초간 일시정지 도중에 user2 스레드가 200으로 대입(병렬처리)
            // 주의할점 : 두개 이상의 스레드가 하나의 메소드 호출할때 비동기 처리를 한다.
            // 두개 이상의 스레드가 하나의 메소드를 순서대로 호출할때 동기 처리한다.
                // -> 두개 이상의 스레드가 하나의메소드를 요청하면 먼저 요청한 스레드가 종료될때까지 다음 스레드는 대기상태
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(this.memory); // 100 200 X 200 200 O
    }
}

// 실행 클래스
public class Example4 {
    public static void main(String[] args) {
        // 1. 계산기 객체 생성한다.
        Calculator calculator = new Calculator();
        // 2. 각 객체에 동일한 계산기를 대입
        User1 user1 = new User1();
        user1.calculator = calculator;
        User2 user2 = new User2();
        user2.calculator = calculator;
        // 3. 각 객체가 계산기에 대입하는 병렬처리
        user1.start(); // <-- synchronized 전 : 200 vs synchronized 후 : 100
        user2.start(); // <-- synchronized 전 : 200 vs synchronized 후 : 200
    }
}
// ?? user1 user2 두 객체가 동일한 calculator 객체를 사용
//user1.calculator.memory = 100;
//System.out.println(user2.calculator.memory);
//