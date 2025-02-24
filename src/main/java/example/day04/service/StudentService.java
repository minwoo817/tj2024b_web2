package example.day04.service;

import example.day04.model.dto.StudentDto;
import example.day04.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    // [1]
    public int save(StudentDto studentDto){
        return studentMapper.save(studentDto);
    }

    // [2]
    public List<StudentDto> findAll(){
        return studentMapper.findAll();
    }
    // [3]
    public int update(StudentDto studentDto){
        return studentMapper.update(studentDto);
    }
    public int delete(int id){
        return studentMapper.delete(id);
    }
}
