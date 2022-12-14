package site.metacoding.firstapp.web.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LoginDto {
    private Integer userId;
    private String userName;
    private String password;
}
