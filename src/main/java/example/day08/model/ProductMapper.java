package example.day08.model;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Select("select * from productsample")
    public List<ProductDto> onRead();

    @Insert("insert into productsample(name, price, comment) values (#{name}, #{price} , #{comment})")
    public boolean onCreate(ProductDto productDto);

    @Update("update productsample set name = #{name}, price = #{price}, comment = #{comment} where id = #{id}")
    public boolean onUpdate(ProductDto productDto);

    @Delete("delete from productsample where id = #{id}")
    public boolean onDelete(int id);
}
