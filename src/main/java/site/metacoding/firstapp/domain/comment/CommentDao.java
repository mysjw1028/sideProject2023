package site.metacoding.firstapp.domain.comment;

import java.util.List;

import site.metacoding.firstapp.web.dto.comment.CommentReadDto;

public interface CommentDao {
        public void insert(Comment comment);

        public List<CommentReadDto> commentOnly(Integer postId);

        public void findAll();

        public void findById();

        public void update();

        public void deleteById();
}
