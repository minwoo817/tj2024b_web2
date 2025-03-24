package example.day10.멀티스레드;

import java.awt.*;

public class Example1 {
    // 1. main 함수는 main 스레드를 포함하며 코드를 첫 시작한다.
    public static void main(String[] args) {
        System.out.println("(1) main 스레드가 읽어들이는 코드");

        // 2. main 함수 안에서 작성된 코드는 모두 main 스레드가 읽어드린다.
        for(int i = 1; i<=5; i++){
            System.out.println("(2) main 스레드가 읽어드리는 코드" + i);
        }

        // 3.
        Toolkit toolkit = Toolkit.getDefaultToolkit(); //java ui 제공하는 패키지(java.awt)
        // 3-1 소리 5번 진행
        for(int i = 1; i <=5; i++){
            toolkit.beep(); // 비프음('띵') 발생
            // * 스레드 일시정지
            try{Thread.sleep(1000); // Thread.sleep(밀리초); 예외발생
            } catch(Exception e) {
                System.out.println(e);
            }
        }
        // 3-2 출력 5번 발생
        for(int i = 1; i <=5; i++){
            System.out.println("띵");
            try{Thread.sleep(1000);
            }catch (Exception e) {
                System.out.println(e);
            }
        }

        // 4. 멀티 스레드 (1) 익명 객체
        // 4-1 : 소리 5번 발생 , 작업스레드 정의
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Toolkit toolkit1 = Toolkit.getDefaultToolkit();
                for(int i = 1; i <= 5; i++){
                    toolkit1.beep(); // 비프음
                    try{Thread.sleep(1000);
                    } catch(Exception e) {
                        System.out.println(e);
                    }
                }
            }
        });
        thread.start();
        // 4-2 : 출력 5번 발생 , 위 예제 코드 복사
        for(int i = 1; i <=5; i++){
            System.out.println("띵");
            try{Thread.sleep(1000);
            }catch (Exception e) {
                System.out.println(e);
            }
        }

        // 5. 멀티스레드 (2) 구현 객체
        System.out.println("멀티스레드 시작");
        // 5-1 : 소리 5번 발생, 작업스레드 정의
        비프음1 비프음1 = new 비프음1();
        Thread 비프음스레드1 = new Thread(비프음1);
        비프음스레드1.start();
        // 5-2 : 출력 5번 발생 , (위 예제 코드 복사)
        for(int i = 1; i <=5; i++){
            System.out.println("띵");
            try{Thread.sleep(1000);
            }catch (Exception e) {
                System.out.println(e);
            }
        }

        // 6. 멀티스레드 (3) 상속 객체
        // 6-1 : 소리 5번 발생 , 작업스레드 정의
        비프음2 비프음2 = new 비프음2();
        비프음2.start();
        // 6-2 : 출력 5번 발생 , (위 예제 코드 복사)
        for(int i = 1; i <=5; i++){
            System.out.println("띵");
            try{Thread.sleep(1000);
            }catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}
