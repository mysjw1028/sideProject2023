package site.metacoding.firstapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.user.User;
import site.metacoding.firstapp.domain.user.UserDao;
import site.metacoding.firstapp.web.dto.user.JoinDto;
import site.metacoding.firstapp.web.dto.user.LoginDto;
import site.metacoding.firstapp.web.dto.user.PasswordCheckDto;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserDao userDao;

    @Transactional(rollbackFor = RuntimeException.class) // 회원가입시 중복되지 않게 방지 할려고
    public void 회원가입(JoinDto joinDto) {
        User user = joinDto.toEntity();
        userDao.insert(user);
    }// 컨트롤러가 일 안함/

    public boolean 아이디중복체크(String userName) {
        User userPS = userDao.findByIdUserName(userName);
        if (userPS == null) { // 아이디가 중복 안됨
            return false;
        } else { // 아이디가 중복됨
            return true;
        }
    }

    public User 로그인(LoginDto loginDto) {
        User usersPS = userDao.login(loginDto);
        if (usersPS == null) {
            return null;
        }
        if (usersPS.getPassword().equals(loginDto.getPassword())) {
            return usersPS;
        } else {
            return null;
        }
    }

    public User 비밀번호확인(PasswordCheckDto passwordCheckFormDto) {
        User userPS = userDao.passwordCheckForm(passwordCheckFormDto);

        System.out.println("디버그 서비스: " + passwordCheckFormDto.getPassword());

        if (userPS == null) {
            return null;
        }
        if (userPS.getPassword().equals(passwordCheckFormDto.getPassword())) {
            return userPS;
        } else {
            return null;
        }
    }

}
