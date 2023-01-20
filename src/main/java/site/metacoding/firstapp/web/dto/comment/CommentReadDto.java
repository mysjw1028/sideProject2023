package site.metacoding.firstapp.web.dto.comment;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CommentReadDto {
    private Integer commentId;
    private Integer userId;
    private Integer postId;
    private String categoryTitle;
    private Integer categoryId;
    private String nickName;
    private String commentContent;
    private Timestamp updatedAt;
    private Timestamp createdAt;
}
