package example.day08.service;

import example.day08.model.ProductDto;
import example.day08.model.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 스프링 빈 등록
public class ProductService {
    @Autowired
    private ProductMapper productMapper;
    // [전체 조회]
    public List<ProductDto> onRead(){
        System.out.println("ProductService.onRead");
        return productMapper.onRead();
    }

    // [제품 등록]
    public boolean onCreate(ProductDto productDto){
        System.out.println("ProductService.onCreate");
        return productMapper.onCreate(productDto);
    }
    // [제품 수정]
    public boolean onUpdate(ProductDto productDto){
        System.out.println("ProductService.onUpdate");
        return productMapper.onUpdate(productDto);
    }
    // [제품 삭제]
    public boolean onDelete(int id){
        System.out.println("ProductService.onDelete");
        return productMapper.onDelete(id);
    }
}
