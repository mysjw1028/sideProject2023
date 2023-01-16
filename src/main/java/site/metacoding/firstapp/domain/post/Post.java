package site.metacoding.firstapp.domain.post;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.firstapp.domain.img.ImgDto;

@Getter
@Setter
public class Post {
    private Integer postId;
    private Integer userId;
    private Integer categoryId;
    private String postTitle;
    private String postContent;
    private String postThumnail;
    private Timestamp updatedAt;
    private Timestamp createdAt;

    // db에 없는값
    private Integer loveCount;
    private String postCount;
    private Integer loveId;
    private String categoryTitle;
    private String nickName;

    // 페이징
    private Integer startNum;

    public void update(ImgDto imgDto) {
        this.postId = imgDto.getPostId();
        this.categoryId = imgDto.getCategoryId();
        this.postTitle = imgDto.getPostTitle();
        this.postContent = imgDto.getPostContent();
        this.postThumnail = imgDto.getPostThumnail();
    }

}
