package example.day11._스프링스케줄링과제;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TaskService {
    @Autowired
    private TaskMapper taskMapper;
    @Scheduled(cron = "*/30 * * * * *")
    public void task1(){
        System.out.println("30초마다 모든 제품 재고 3개 감소");
        taskMapper.task1();
    }
    @Scheduled(cron = "0 */1 * * * *")
    public void task2(){
        System.out.println("1분마다  모든 제품 조회");
        List<Map<String, Object>> tasks = taskMapper.task2();
        for (Map<String, Object> task : tasks) {
            System.out.println(task);
        }
    }
    @Scheduled(cron = "0 */5 * * * *")
    public void task3(){
        System.out.println("5분마다 재고 10 이하 상품 재고 20 추가");
        taskMapper.task3();
    }
}
