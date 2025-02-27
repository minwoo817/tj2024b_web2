package example.day06._aop과제.controller;

import example.day06._aop과제.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day06/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // [1] 학생 점수 등록
    @PostMapping("")
    public int save(@RequestBody Map<String, Object> map) {
        return studentService.save(map);
    }
    // [2] 학생 전체 조회
    @GetMapping("")
    public List<Map<String, Object>> findAll() {
        return studentService.findAll();
    }

}
