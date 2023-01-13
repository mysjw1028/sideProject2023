package site.metacoding.firstapp.web.dto.post;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostListDto {
    private Integer postId;
    private Integer categoryId;
    private String postTitle;
    private String nickName;
    private String username;
    private String postContent;
    private String postThumnail;

    private Integer userId;
    private Timestamp updatedAt;
    private Timestamp createdAt;

    // db에 없는값

    private String categoryTitle;
    private String keyword;

    // 페이징
    private Integer startNum;
}
