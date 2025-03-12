package example.day08task.controller;

import example.day08task.model.BookDto;
import example.day08task.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day08task/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("")
    public boolean onCreate(@RequestBody BookDto bookDto){
        return bookService.onCreate(bookDto);
    }

    @GetMapping("")
    public List<BookDto> onRead(){
        return bookService.onRead();
    }

    @GetMapping("/view")
    public BookDto onView(@RequestParam int bno){
        return bookService.onView(bno);
    }

    @PutMapping("")
    public boolean onUpdate(@RequestBody BookDto bookDto){
        return bookService.onUpdate(bookDto);
    }

    @DeleteMapping("")
    public boolean onDelete(@RequestParam int bno, String pwd){
        return bookService.onDelete(bno, pwd);
    }

}
