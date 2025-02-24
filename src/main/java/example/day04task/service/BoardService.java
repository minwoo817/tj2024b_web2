package example.day04task.service;

import example.day04task.model.dto.BoardDto;
import example.day04task.model.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;

    public int save(BoardDto boardDto){
        System.out.println("BoardService.save");
        System.out.println("boardDto = " + boardDto);
        return boardMapper.save(boardDto);
    }
    public List<BoardDto> findAll(){
        return boardMapper.findAll();
    }
    public BoardDto find(int bno){
        return boardMapper.find(bno);
    }
    public int update(BoardDto boardDto){
        return boardMapper.update(boardDto);
    }
    public int delete(int bno){
        return boardMapper.delete(bno);
    }
}
