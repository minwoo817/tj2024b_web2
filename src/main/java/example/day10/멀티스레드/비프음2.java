package example.day10.멀티스레드;

import java.awt.*;

public class 비프음2 extends Thread{

    @Override // 상속된 메소드 재정의
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
}
