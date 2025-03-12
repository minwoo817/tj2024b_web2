package example.day08task.model;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private int bno;
    private String title;
    private String writer;
    private String commend;
    private String pwd;
}
