package site.metacoding.firstapp.web.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostUpdateReqDto {
    private Integer userId;
    private Integer postId;
    private Integer categoryId;
    private String categoryTitle;
    private String postTitle;
    private String postContent;
    private String postThumnail;
}
