package site.metacoding.firstapp.domain.post;

import java.util.List;

public interface PostDao {
    public void insert(Post post);

    public void findAll(Post post);

    public Post findById(Integer postId);

    public int update(Post post);

    public void deleteById(Post post);

    public List<Post> readOnly();

}
