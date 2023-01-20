package site.metacoding.firstapp.domain.comment;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import site.metacoding.firstapp.web.dto.comment.CommentReadDto;

public interface CommentDao {
        public void insert(Comment comment);

        public List<CommentReadDto> commentOnly(@Param("userId") Integer userId, @Param("postId") Integer postId);

        public void findAll();

        public Comment findById(Integer commentId);

        public void update(Comment comment);

        public void deleteById();

}
