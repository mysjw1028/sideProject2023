package site.metacoding.firstapp.domain.love;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Love {
    private Integer loveId;
    private Integer userId;
    private Integer postId;
    private Timestamp updatedAt;
    private Timestamp createdAt;
}
