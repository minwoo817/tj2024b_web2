package example.day08task.controller;

import example.day08task.model.ReviewDto;
import example.day08task.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day08task/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("")
    public boolean onWrite(@RequestBody ReviewDto reviewDto){
        return reviewService.onWrite(reviewDto);
    }

    @GetMapping("")
    public List<ReviewDto> onFind(@RequestParam int bno){
        return reviewService.onFind(bno);
    }

    @DeleteMapping("")
    public boolean onDelete(@RequestParam int rno , String pwd){
        return reviewService.onDelete(rno, pwd);
    }
}
