package example.day10.멀티스레드;

import java.util.Scanner;

//[멀티스레드 문제] 스마트폰에서 멀티태스킹 구현하기.
//음악 기능: 음악을 실행하면 "음악 재생 중..."이 1초마다 출력됩니다.
//웹서핑 기능: 웹서핑을 실행하면 "웹서핑 중..."이 1초마다 출력됩니다.
//        -> 실행중인 상태에서 해당 입력 번호가 들어오면 종료 합니다.
//사용자는 다음과 같은 명령을 입력할 수 있습니다.
//   1을 입력하면 음악 기능을 ON/OFF 합니다.
//        2를 입력하면 웹서핑 기능을 ON/OFF 합니다.
//        0을 입력하면 프로그램을 종료합니다.
//        [실행 예]
//        1. 뮤직 ON/OFF | 2. 웹서핑 ON/OFF | 0. 종료
//   >> 1
//음악 시작!
//음악 재생 중...
//음악 재생 중...
//        >> 2
//웹서핑 시작!
//웹서핑 중...
//음악 재생 중...
//웹서핑 중...
//        >> 1
//음악 종료!
//웹서핑 중...
//웹서핑 중...
//        >> 2
//웹서핑 종료!
//        >> 0
//스마트폰 종료...
class Music extends Thread{
 boolean state1 = false;

    @Override
    public void run() {
        try{
            while(state1){
                Thread.sleep(1000);
                System.out.println("음악 재생중...");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Web extends Thread{
    boolean state2 = false;
    @Override
    public void run() {
        try{
            while(state2){
                Thread.sleep(1000);
                System.out.println("웹서핑 중...");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class Task1 {
    public static void main(String[] args) {
        Music music = new Music();
        Web web = new Web();
        boolean state3 = true;
        while(state3){
            Scanner scan = new Scanner(System.in);
            System.out.println("1. 뮤직 ON/OFF | 2. 웹서핑 ON/OFF | 0. 종료");
            int ch = scan.nextInt();
            if(ch == 1){
                if(music.state1 == false){
                    music.state1 = true;
                    music.start();
                    System.out.println("음악 시작!");
                } else if(music.state1 == true){
                    music.state1 = false;
                    System.out.println("음악 종료!");
                }
            }
            else if(ch == 2){
                if(web.state2 == false){
                    web.state2 = true;
                    web.start();
                    System.out.println("웹서핑 시작!");

                } else if(web.state2 == true){
                    web.state2 = false;
                    System.out.println("웹서핑 종료!");
                }
            }
            else if(ch == 0){
                state3 = false;
                music.state1 = false;
                web.state2 = false;
                System.out.println("스마트폰 종료...");
            }
        }
    }
}
