package site.metacoding.firstapp.web.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import site.metacoding.firstapp.domain.user.User;

@Getter
@NoArgsConstructor
public class LoginRespDto {
    private Integer userId;
    private String userName;
    private String password;

    public LoginRespDto(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
           this.password = user.getPassword();
	}
}
