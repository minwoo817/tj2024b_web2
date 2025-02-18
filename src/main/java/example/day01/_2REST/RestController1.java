package example.day01._2REST;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 해당 클래스는 Controller 임을 알림(어노테이션 기능 주입)
// - 1. 해당 클래스는 spring 컨테이너(메모리)에 bean(객체) 등록한다.
// - 2. Controller 는 기본적으로 HTTP 서블릿 지원한다.
public class RestController1 {

    // [1] RequestMapping(value ="http 주소 정의", method = RequestMethod.사용할 HTTP 메소드)
    // - 1. value 속성에 매핑할 HTTP 주소 정의한다. * http://localhost:8080/(http 주소 정의)
    //      value = "/day01/doget" -> http://localhost:8080/day01/doget
    // 2. method = RequestMethod.POST/GET/PUT/DELETE 선택해서 사용한다.
    @RequestMapping(value = "/day01/doget", method = RequestMethod.GET)
    public void doGet(){
        System.out.println("day01 doGet executed");
    }

    // [2]
    @RequestMapping(value ="/day01/dopost", method = RequestMethod.POST)
    public void doPost(){
        System.out.println("day01 doPost executed");
    }
    // [3]
    @RequestMapping(value = "/day01/doput", method = RequestMethod.PUT)
    public void doPut(){
        System.out.println("day01 doPut executed");
    }
    // [4]
    @RequestMapping(value = "/day01/dodelete", method = RequestMethod.DELETE)
    public void doDelete(){
        System.out.println("day01 doDelete executed");
    }
}
