package site.metacoding.firstapp.domain.post;

import java.util.List;

import site.metacoding.firstapp.web.dto.post.PostReadDto;
import site.metacoding.firstapp.web.dto.post.PostUpdateRespDto;

public interface PostDao {
    public void insert(Post post);

    public List<Post> findAll();

    public Post findByDetail(Integer postId);

    public Post findById(Integer postId);

    public void deleteById(Post post);

    public List<PostReadDto> readOnly();

    public List<PostUpdateRespDto> updateView(Integer postId);

    public void update(Post post);

}
