package site.metacoding.firstapp.domain.user;

import site.metacoding.firstapp.web.dto.user.LoginDto;
import site.metacoding.firstapp.web.dto.user.PasswordCheckDto;

public interface UserDao {

    public void insert(User user);

    public void findAll(User user);

    public void findById(Integer integer);

    public void update(User user);

    public void deleteById(User user);

    public User login(LoginDto loginDto);

    public User findByIdUserName(String username);
    // 아이디 중복체크

    public User passwordCheckForm(PasswordCheckDto passwordCheckDto);
    // 비밀번호 체크 -> 계정관리 전 체크함

}
