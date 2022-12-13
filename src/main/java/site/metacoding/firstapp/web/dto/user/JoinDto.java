package site.metacoding.firstapp.web.dto.user;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.firstapp.domain.user.User;

@Getter
@Setter
public class JoinDto {
    private Integer usersId;
    private String userName;
    private String password;
    private String email;
    private String nickName;

    public User toEntity() {
        User user = new User(this.userName, this.password, this.email, this.nickName);
        return user;
    }
}
