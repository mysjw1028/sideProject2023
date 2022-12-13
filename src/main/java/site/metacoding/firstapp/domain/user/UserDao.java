package site.metacoding.firstapp.domain.user;

public interface UserDao {

    public void insert(User user);

    public void findAll(User user);

    public void findById(User user);

    public void update(User user);

    public void deleteById(User user);

}
