package site.metacoding.firstapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {



    @GetMapping("/subscribe/listForm")
    public String 구독관리() {
        return "subscribe/listForm";
    }

    @GetMapping("user/profileUpdateForm")
    public String 사진업로드() {
        return "user/profileUpdateForm";
    }

    @GetMapping("user/leaveCheckForm")
    public String 계정관리() {
        return "user/leaveCheckForm";
    }

    @GetMapping("user/emailCheckForm")
    public String 이메일관리() {
        return "user/emailCheckForm";
    }

    @GetMapping("user/passwordUpdateForm")
    public String 패스워드관리() {
        return "user/passwordUpdateForm";
    }
    // post -> 블로그??

}
