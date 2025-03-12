package example.day08task.model;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private int rno;
    private String content;
    private String pwd;
    private int bno;
}
