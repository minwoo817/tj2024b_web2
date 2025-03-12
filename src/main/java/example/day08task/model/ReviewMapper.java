package example.day08task.model;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReviewMapper {
    @Insert("insert into reviews(content, bno, pwd) values(#{content}, #{bno}, #{pwd})")
    public boolean onWrite(ReviewDto reviewDto);

    @Select("select * from reviews where bno = #{bno}")
    public abstract List<ReviewDto> onFind(int bno);

    @Delete("delete from reviews where rno = #{rno} and pwd = #{pwd}")
    public boolean onDelete(int rno, String pwd);
}
