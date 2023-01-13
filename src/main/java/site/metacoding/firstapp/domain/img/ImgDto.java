package site.metacoding.firstapp.domain.img;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImgDto {
    private Integer id;
    private String postTitle;
    private String imgName;
    private String postContent;
    private String postThumnail;
    private Integer userId;
    private Integer postId;
    private String categoryTitle;
    private Integer categoryId;
    private Timestamp createdAt;

    public Img toEntity(String imgName) {
        Img img = new Img(this.postTitle, imgName, this.postContent);
        return img;
    }
}
