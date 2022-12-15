package site.metacoding.firstapp.domain.post;

import java.util.List;

public interface PostDao {
    public void insert(Post post);

    public void findAll(Post post);

    public void findById(Post post);

    public int update(Post post);

    public void deleteById(Post post);

    public List<Post> readOnly(Post post);

}
