package site.metacoding.firstapp.domain.user;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.metacoding.firstapp.web.dto.user.LoginDto;

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

    // 디비에 없는값
    private Integer postId;

    public User(String userName, String password, String email, String nickName) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.nickName = nickName;
    }// 회원가입용

    public User(Integer userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public User(LoginDto loginDto) {
        this.userId = loginDto.getUserId();
        this.userName = loginDto.getUserName();
        this.password = loginDto.getPassword();
    }

}
