package example.day08task.service;

import example.day08task.model.BookDto;
import example.day08task.model.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    public boolean onCreate(BookDto bookDto){
        return bookMapper.onCreate(bookDto);
    }
    public List<BookDto> onRead(){
        return bookMapper.onRead();
    }
    public BookDto onView(int bno){
        return bookMapper.onView(bno);
    }
    public boolean onUpdate(BookDto bookDto){
        return bookMapper.onUpdate(bookDto);
    }
    public boolean onDelete(int bno, String pwd){
        return bookMapper.onDelete(bno, pwd);
    }
}
