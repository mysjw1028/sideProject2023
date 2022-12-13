package site.metacoding.firstapp.domain.user;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String nickName;
    private String email;
    private Timestamp createdAt;
}
