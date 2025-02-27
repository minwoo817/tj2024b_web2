package example.day06._aop과제.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    @Insert("insert into student(name, kor, math) values(#{name}, #{kor}, #{math})")
    public int save(Map<String, Object> map);

    @Select("select * from student")
    public List<Map<String, Object>> findAll();
}
