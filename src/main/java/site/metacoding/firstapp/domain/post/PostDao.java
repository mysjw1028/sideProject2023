package site.metacoding.firstapp.domain.post;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import site.metacoding.firstapp.domain.category.Category;
import site.metacoding.firstapp.web.dto.post.PostDatailDto;
import site.metacoding.firstapp.web.dto.post.PostReadDto;
import site.metacoding.firstapp.web.dto.post.PostUpdateRespDto;

public interface PostDao {
    public void insert(Post post);

    public List<Post> findAll(Integer userId);

    public List<Category> findAllcategory(Integer userId);

    public Post findById(Integer postId);

    public void deleteById(Integer postId);

    public PostDatailDto detailOnly(Integer postId);

    public List<PostReadDto> readOnly(Integer userId);

    public List<PostUpdateRespDto> updateView(@Param("postId") Integer postId, @Param("userId") Integer userId);

    public void update(Post post);

    public PostDatailDto findByDetail(@Param("postId") Integer postId, @Param("userId") Integer userId);
}
