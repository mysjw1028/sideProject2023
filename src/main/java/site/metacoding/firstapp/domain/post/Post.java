package site.metacoding.firstapp.domain.post;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Post {
    private Integer postId;
    private String postTitle;
    private String postContent;
    private String postThumnail;
    private Integer categoryId;
    private Integer userId;
    private Timestamp updatedAt;
    private Timestamp createdAt;

    // db에 없는값
    private Integer loveCount;
    private Integer loveId;

}
