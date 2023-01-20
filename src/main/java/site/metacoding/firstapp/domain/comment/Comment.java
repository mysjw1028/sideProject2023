package site.metacoding.firstapp.domain.comment;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

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

    public void update(Comment comment) {
        this.commentContent = getCommentContent();
    }
}
