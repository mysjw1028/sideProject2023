package site.metacoding.firstapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.comment.Comment;
import site.metacoding.firstapp.domain.comment.CommentDao;
import site.metacoding.firstapp.web.dto.comment.CommentRespUpdateDto;

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
    public String 댓글수정(@PathVariable Integer commentId, @PathVariable Integer userId, @PathVariable Integer postId,
            Model model) {
        Comment commentPS = commentDao.findById(commentId);
        System.out.println(" 디버그 reply업뎃 : " + commentPS.getCommentContent());
        model.addAttribute("comment", commentPS);
        return "post/replyupdate";
    }

    @PostMapping("/post/comment/update/{commentId}/{userId}")
    public String replyupdate(@PathVariable Integer commentId,
            Comment comment, CommentRespUpdateDto commentRespUpdateDto) {
        System.out.println("디버그 맨 위 " + comment.getCommentContent());// jsp에서 값 넘어오는지 확인 가능
        System.out.println("디버그 00000" + comment);
        Comment commentPS = commentDao.findById(commentId); // 영속화
        System.out.println("디버그 1111111" + commentDao.findById(commentId));
        commentPS.update(commentRespUpdateDto); // 변경
        System.out.println("디버그 22222" + commentPS.getCommentContent());
        System.out.println("디버그 중간 " + comment.getCommentContent());
        commentDao.update(commentRespUpdateDto);// 수행
        System.out.println("디버그 333333 " + commentPS.getCommentContent());
        System.out.println("디버그 마지막 " + comment.getCommentContent());
        return "redirect:/";
    }

}
