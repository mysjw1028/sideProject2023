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
public class PostDetail {

    private Integer loveId;
    private Integer usersId;
    private Integer postId;
    private String postTitle;
    private String PostContent;
    private Integer loveCount;
    private boolean isLoved;
    private Timestamp createdAt;
}
