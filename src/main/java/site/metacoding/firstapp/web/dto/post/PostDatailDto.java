package site.metacoding.firstapp.web.dto.post;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDatailDto {
    private Integer postId;
    private Integer userId;
    private String postTitle;
    private String postContent;
    private String postThumnail;
    private String nickName;

    private Timestamp createdAt;
}
