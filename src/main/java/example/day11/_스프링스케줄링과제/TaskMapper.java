package example.day11._스프링스케줄링과제;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface TaskMapper {
    @Update("update day11products set stock_quantity = stock_quantity -3")
    public void task1();

    @Select("select * from day11products")
    public abstract List<Map<String, Object>> task2();

    @Update("update day11products set stock_quantity = stock_quantity +20 where stock_quantity <= 10")
    public void task3();
}
