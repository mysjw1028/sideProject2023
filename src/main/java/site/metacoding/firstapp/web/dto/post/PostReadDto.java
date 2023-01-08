package site.metacoding.firstapp.web.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostReadDto {
    private Integer userId;
    private Integer categoryId;
    private String postTitle;
    private String categoryTitle;
    private String postContent;
    private String postThumnail;
    
}
