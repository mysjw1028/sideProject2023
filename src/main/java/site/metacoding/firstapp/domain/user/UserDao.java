package site.metacoding.firstapp.domain.user;

import site.metacoding.firstapp.web.dto.user.LoginDto;

public interface UserDao {

    public void insert(User user);

    public void findAll(User user);

    public void findById(User user);

    public void update(User user);

    public void deleteById(User user);

    public User login(LoginDto loginDto);

}
