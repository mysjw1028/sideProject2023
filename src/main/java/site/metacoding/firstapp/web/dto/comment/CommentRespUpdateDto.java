package site.metacoding.firstapp.web.dto.comment;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRespUpdateDto {
    private Integer commentId;
    private Integer userId;
    private String commentContent;
    private Timestamp updatedAt;

}
