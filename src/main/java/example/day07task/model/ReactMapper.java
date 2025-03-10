package example.day07task.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
@Mapper
public interface ReactMapper {

        @Insert("insert into phonesave(name, phone) values(#{name}, #{phone})")
        public boolean onPost(Map<Object,String> map);

        @Select("select * from phonesave")
        public abstract List<Map<Object,String>> onFindAll();
}
