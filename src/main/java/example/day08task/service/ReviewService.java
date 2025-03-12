package example.day08task.service;

import example.day08task.model.ReviewDto;
import example.day08task.model.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;

    public boolean onWrite(ReviewDto reviewDto){
        return reviewMapper.onWrite(reviewDto);
    }
    public List<ReviewDto> onFind(int bno){
        return reviewMapper.onFind(bno);
    }
    public boolean onDelete(int bno, String pwd){
        return reviewMapper.onDelete(bno, pwd);
    }
}
