package site.metacoding.firstapp.domain.love;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Love {
    private Integer loveId;
    private Integer userId;
    private Integer postId;
    private Timestamp createdAt;

    public Love(Integer userId, Integer postId) {
        this.userId = userId;
        this.postId = postId;
    }
}
