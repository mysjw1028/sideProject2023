package site.metacoding.firstapp.domain.category;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {

    private Integer category;
    private String categoryTitle;
    private Integer userId;
    private Timestamp createdAt;
}
