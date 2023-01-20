package site.metacoding.firstapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.comment.Comment;
import site.metacoding.firstapp.domain.comment.CommentDao;

@RequiredArgsConstructor
@Controller
public class ReplyController {
    private final CommentDao commentDao;

    @PostMapping("/post/comment/write/{postId}/{userId}")
    public String replylnsert(Comment comment, @PathVariable Integer postId, @PathVariable Integer userId) {
        commentDao.insert(comment);
        return "redirect:/";
    }

    @GetMapping("/post/comment/update/{commentId}/{postId}/{userId}")
    public String 댓글수정(@PathVariable Integer commentId, @PathVariable Integer userId, @PathVariable Integer postId) {
        Comment commentPS = commentDao.findById(commentId);
        System.out.println(" 디버그 reply업뎃 : " + commentPS.getCommentContent());

        return "post/replyupdate";
    }

    @PostMapping("/post/comment/update/{commentId}/{postId}/{userId}")
    public String replyupdate(@PathVariable Integer commentId, @PathVariable Integer userId,
            @PathVariable Integer postId) {
        Comment commentPs = commentDao.findById(commentId);

        return "post/replyupdate";
    }

}
