package example.day07task.controller;

import example.day07task.service.ReactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day07task/react")
@CrossOrigin("http://192.168.40.27:5173")
public class ReactController {
    @Autowired
    private ReactService reactService;

    private List<Map<Object,String>> boards = new ArrayList<>();
    @PostMapping("")
    public boolean onPost(@RequestBody Map<Object,String> map) {
        System.out.println("ReactController onPost");
        System.out.println("map = " + map);
        boards.add(map);
        return reactService.onPost(map);
    }
    @GetMapping("")
    public List<Map<Object,String>> onFindAll() {
        System.out.println("ReactController onFindAll");
        return reactService.onFindAll();
    }
}
