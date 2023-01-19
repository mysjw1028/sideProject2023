package site.metacoding.firstapp.domain.comment;

public interface CommentDao {
        public void insert(Comment comment);

        public Comment replyDetail(Integer userId);

        public void findAll();

        public void findById();

        public void update();

        public void deleteById();
}
