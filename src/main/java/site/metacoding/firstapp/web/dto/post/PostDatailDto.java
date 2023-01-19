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
public class PostDatailDto {
    private Integer loveId;
    private Integer postId;
    private Integer userId;
    private Integer commentId;
    private String commentContent;
    private String postTitle;
    private String categoryTitle;
    private Integer categoryId;
    private String postContent;
    private String postThumnail;
    private String nickName;
    private Integer loveCount;
    private boolean isLoved;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
