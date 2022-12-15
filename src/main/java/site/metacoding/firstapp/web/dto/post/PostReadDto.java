package site.metacoding.firstapp.web.dto.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostReadDto {
    private Integer userId;
    private Integer categoryId;
    private String categoryTitle;
    private String postContent;
    private String postThumnail;
}
