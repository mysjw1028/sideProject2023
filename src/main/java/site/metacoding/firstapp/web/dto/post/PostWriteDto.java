package site.metacoding.firstapp.web.dto.post;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostWriteDto {
    private Integer userId;
    private String postTitle;
    private String categoryTitle;
    private Integer categoryId;
    private String postContent;
    private String postThumnail;
    private Timestamp createdAt;
}
