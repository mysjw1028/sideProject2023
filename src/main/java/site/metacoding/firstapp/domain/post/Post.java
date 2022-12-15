package site.metacoding.firstapp.domain.post;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
    private Integer postId;
    private String postTitle;
    private String postContent;
    private Integer categoryId;
    private Integer userId;
    private Timestamp createdAt;
}
