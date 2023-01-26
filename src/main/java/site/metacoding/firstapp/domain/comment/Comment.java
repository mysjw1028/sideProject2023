package site.metacoding.firstapp.domain.comment;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.firstapp.web.dto.comment.CommentRespUpdateDto;

@Getter
@Setter
public class Comment {
    private Integer commentId;
    private Integer userId;
    private Integer postId;
    private String commentContent;
    private Timestamp updatedAt;
    private Timestamp createdAt;

    // 가짜데이터
    private String nickName;

    public void update(CommentRespUpdateDto commentRespUpdateDto) {
        this.commentContent = commentRespUpdateDto.getCommentContent();
    }
}
