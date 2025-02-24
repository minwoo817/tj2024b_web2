package example.day04task.controller;

import example.day04task.model.dto.BoardDto;
import example.day04task.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day04/task/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @PostMapping("")
    public int save(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.save");
        System.out.println("boardDto = " + boardDto);
        return boardService.save(boardDto);
    }

    @GetMapping("")
    public List<BoardDto> findAll(){
        return boardService.findAll();
    }

    @GetMapping("/view")
    public BoardDto find(@RequestParam int bno){
        return boardService.find(bno);
    }

    @PutMapping("")
    public void update(@RequestBody BoardDto boardDto){
        boardService.update(boardDto);
    }

    @DeleteMapping("")
    public void delete(@RequestParam int bno){
        boardService.delete(bno);
    }

}
