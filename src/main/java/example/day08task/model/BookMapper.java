package example.day08task.model;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {
    @Insert("insert into books(title, writer, commend, pwd) values(#{title}, #{writer}, #{commend}, #{pwd})")
    public boolean onCreate(BookDto bookDto);

    @Select("SELECT * FROM books")
    public abstract List<BookDto> onRead();

    @Select("SELECT * FROM books where bno = #{bno}")
    public BookDto onView(int bno);

    @Update("UPDATE books SET title = #{title}, writer = #{writer}, commend = #{commend} WHERE bno = #{bno} and pwd = #{pwd}")
    public boolean onUpdate(BookDto bookDto);

    @Delete("delete from books where bno = #{bno} and pwd = #{pwd}")
    public boolean onDelete(int bno, String pwd);
}
