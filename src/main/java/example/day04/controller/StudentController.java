package example.day04.controller;

import example.day04.model.dto.StudentDto;
import example.day04.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day04/student")
public class StudentController {
    @Autowired // 스프링 컨테이너 빈(인스턴스) 주입
    private StudentService studentService;

    @PostMapping("")
    public int save(@RequestBody StudentDto studentDto) {
        System.out.println("StudentController.save()");
        System.out.println("studentDto = " + studentDto);
        return studentService.save(studentDto);
    }

    @GetMapping("")
    public List<StudentDto> findAll(){
        System.out.println("StudentController.findAll()");
        return studentService.findAll();
    }

    @PutMapping("")
    public int update(@RequestBody StudentDto studentDto){
        System.out.println("StudentController.update()");
        System.out.println("studentDto = " + studentDto);
        return studentService.update(studentDto);
    }

    @DeleteMapping("")
    public int delete(@RequestParam int sno){
        System.out.println("StudentController.delete()");
        System.out.println("sno = " + sno);
        return studentService.delete(sno);
    }

}
