package site.metacoding.firstapp.domain.user;

import org.apache.ibatis.annotations.Param;

public interface UserDao {

    public void insert(User user);

    public void findAll(User user);

    public void findById(User user);

    public void update(User user);

    public void deleteById(User user);

    public User login(@Param("password") String password, @Param("userName") String userName);

}
