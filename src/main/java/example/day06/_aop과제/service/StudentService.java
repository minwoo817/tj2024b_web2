package example.day06._aop과제.service;

import example.day06._aop과제.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;
    // [1] 학생 점수 등록
    public int save( Map<String, Object> map) {
        return studentMapper.save(map);
    }
    // [2] 학생 전체 조회

    public List<Map<String, Object>> findAll() {
        return studentMapper.findAll();
    }

}
