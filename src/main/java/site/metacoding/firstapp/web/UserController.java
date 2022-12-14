package site.metacoding.firstapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.user.User;
import site.metacoding.firstapp.service.UserService;
import site.metacoding.firstapp.web.dto.CMRespDto;
import site.metacoding.firstapp.web.dto.user.JoinDto;
import site.metacoding.firstapp.web.dto.user.LoginDto;
import site.metacoding.firstapp.web.dto.user.PasswordCheckDto;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final HttpSession session; // 스프링이 서버시작시에 IOC 컨테이너에 보관함.
    private final UserService userService;

    @GetMapping("/user/joinForm") // 회원가입
    public String 회원가입페이지() {
        return "user/joinForm";
    }

    @PostMapping("/user/join")
    public @ResponseBody CMRespDto<?> join(@RequestBody JoinDto joinDto) {
        userService.회원가입(joinDto);
        return new CMRespDto<>(1, "회원가입성공", null);
    }

    @GetMapping("/user/join/userNameCheck")
    public @ResponseBody CMRespDto<Boolean> usersNameSameCheck(String userName) {
        boolean isSame = userService.아이디중복체크(userName);
        return new CMRespDto<>(1, "성공", isSame);
    }

    @GetMapping("/user/loginForm")
    public String 로그인페이지() {
        return "user/loginForm";
    }

    @PostMapping("/user/login")
    public @ResponseBody CMRespDto<?> login(@RequestBody LoginDto loginDto) {
        User userPS = userService.로그인(loginDto);
        if (userPS == null) {
            return new CMRespDto<>(-1, "로그인실패", null);
        }
        session.setAttribute("principal", userPS);
        return new CMRespDto<>(1, "로그인성공", null);
    }

    @GetMapping("user/logout")
    public String logout() {
        session.invalidate();// 내 키값에 있는 데이터를 날려버림
        return "redirect:/";// 해당사용자의 키값만 그 사람만 영역만
    }

 
    @GetMapping("/user/passwordCheckForm/{userId}")
    public String 비밀번호체크(Integer userId) {
        return "user/passwordCheckForm";
    }

    @PostMapping("/user/passwordCheck/{userId}")
    public String passeordCheck(PasswordCheckDto passwordCheckDto) {

        User usersPS = userService.비밀번호확인(passwordCheckDto);
        if (usersPS == null) {
        }
        session.setAttribute("principal", usersPS);
        return "user/updateForm";
    }

    @GetMapping("/user/updateForm/{userId}")
    public String 업데이트(Integer userId) {
        return "user/updateForm";
    }

    @PostMapping("/user/updateForm/{userId}")
    public String userupdate(Integer userId) {
        return "user/updateForm";
    }

    @GetMapping("/post/listForm/{userId}")
    public String 내블로그(Integer userId) {
        return "post/listForm";
    }
}
