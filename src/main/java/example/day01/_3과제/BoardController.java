package example.day01._3과제;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day01")
public class BoardController {
    @PostMapping("/task/board")
    public boolean doPostTask(){return true;}

    @GetMapping("/task/board")
            public List<Map<String,String>> doGetTask(){
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map1 = new HashMap<>();
        map1.put("bno" , "1" );
        map1.put("btitle" , "제목1");
        list.add( map1 );
        Map<String,String> map2 = new HashMap<>();
        map2.put("bno" , "2" );
        map2.put("btitle" , "제목2");
        list.add( map2 );
        return list;
    }

    @GetMapping("/task/board/view")
    public Map<String,String> doGetTaskView(){
        Map<String,String> map1 = new HashMap<>();
        map1.put("bno" , "1" );
        map1.put("btitle" , "제목1");
        return map1;
    }
    @PutMapping("/task/board")
    public boolean doPutTask(){return true;}

    @DeleteMapping("/task/board")
    public int doDeleteTask(){return 3;}
}
