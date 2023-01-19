package site.metacoding.firstapp.domain.post;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import site.metacoding.firstapp.domain.category.Category;
import site.metacoding.firstapp.domain.img.ImgDto;
import site.metacoding.firstapp.web.dto.post.PostDatailDto;
import site.metacoding.firstapp.web.dto.post.PostListDto;
import site.metacoding.firstapp.web.dto.post.PostPagingDto;
import site.metacoding.firstapp.web.dto.post.PostReadDto;
import site.metacoding.firstapp.web.dto.post.PostUpdateRespDto;

public interface PostDao {
        public void insert(ImgDto imgDto);

        public List<PostListDto> findAll(@Param("startNum") int startNum, @Param("userId") Integer userId);

        public List<Post> findSearchMain(
                        String keyword);

        public PostPagingDto paging(@Param("page") Integer page, @Param("userId") Integer userId,
                        @Param("keyword") String keyword);

        public List<PostListDto> findSearch(@Param("userId") Integer userId,
                        @Param("keyword") String keyword, @Param("startNum") int startNum);

        public List<Category> findAllcategory(Integer userId);

        public Post findById(Integer postId);

        public void deleteById(Integer postId);

        public PostDatailDto detailOnly(Integer postId);

        public List<PostReadDto> readOnly(Integer userId);

        public List<PostUpdateRespDto> updateView(@Param("postId") Integer postId, @Param("userId") Integer userId);

        public void update(ImgDto imgDto);

        public PostDatailDto findByDetail(@Param("postId") Integer postId, @Param("userId") Integer userId);

}
