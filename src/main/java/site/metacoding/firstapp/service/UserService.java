package site.metacoding.firstapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.user.User;
import site.metacoding.firstapp.domain.user.UserDao;
import site.metacoding.firstapp.web.dto.user.JoinDto;
import site.metacoding.firstapp.web.dto.user.LoginDto;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserDao userDao;

    @Transactional(rollbackFor = RuntimeException.class) // 회원가입시 중복되지 않게 방지 할려고
    public void 회원가입(JoinDto joinDto) {
        User user = joinDto.toEntity();
        userDao.insert(user);
    }// 컨트롤러가 일 안함

    public User 로그인(LoginDto loginDto) {
        User userPS = userDao.login(loginDto.getPassword(), loginDto.getUserName());// param으로 user/ password값을 받게 변경함
        if (userPS == null && userPS.equals(" ")) {
            return null;
        }
        if (userPS.getPassword().equals(loginDto.getPassword())) {
            return userPS;
        } else {
            return null;
        }
    }

}
