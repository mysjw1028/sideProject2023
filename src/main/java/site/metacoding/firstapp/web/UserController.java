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
        System.out.println("디버그  :  로그인 전 이니 없어야 정상    " + session.getAttribute("principal"));
        System.out.println(" 디버그  : 1111111111111111        " + loginDto.getUserId());
        System.out.println(" 디버그  : 1111111111111111        " + loginDto.getUserName());
        System.out.println(" 디버그  : 1111111111111111        " + loginDto.getPassword());
        if (userPS == null) {
            System.out.println("======================================================");
            System.out.println(" 디버그  : 2222222222222222        " + loginDto.getUserId());
            System.out.println(" 디버그  : 2222222222222222        " + loginDto.getUserName());
            System.out.println(" 디버그  : 2222222222222222        " + loginDto.getPassword());
            return new CMRespDto<>(-1, "로그인실패", null);
        }
        session.setAttribute("principal", userPS);
        System.out.println("======================================================");
        System.out.println(" 디버그  : 33333333333sdadassad33333333       " + userPS.getUserName());
        System.out.println(" 디버그  : 33333333333sdadassad33333333       " + userPS.getUserId());
        System.out.println(" 디버그  : 33333333333sdadassad33333333       " + userPS.getPassword());
        System.out.println(" 디버그  : 3333333333333333333       " + loginDto.getUserId());
        System.out.println(" 디버그  : 3333333333333333333        " + loginDto.getUserName());
        System.out.println(" 디버그  : 3333333333333333333        " + loginDto.getPassword());
        return new CMRespDto<>(1, "로그인성공", null);
    }

    @GetMapping("user/logout")
    public String logout() {
        session.invalidate();// 내 키값에 있는 데이터를 날려버림
        return "redirect:/";// 해당사용자의 키값만 그 사람만 영역만
    }

    @GetMapping({ "/", "/mainForm" }) // 화면 출력되는지 확인 완료
    public String 메인페이지() {
        return "mainForm";
    }

    @GetMapping("/user/passwordCheckForm")
    public String 비밀번호체크() {

        return "user/passwordCheckForm";
    }

    @PostMapping("/user/passwordCheck")
    public String passeordCheck(PasswordCheckDto passwordCheckDto) {
        System.out.println("디버그  :  " + passwordCheckDto.getUserId());
        User usersPS = userService.비밀번호확인(passwordCheckDto);
        System.out.println("디버그  :  " + passwordCheckDto.getUserId());

        if (usersPS == null) {
            System.out.println("디버그  null:  " + passwordCheckDto.getUserId());

        }
        session.setAttribute("principal", usersPS);
        System.out.println("디버그  :  " + passwordCheckDto.getUserId());

        return "user/updateForm";
    }

    @GetMapping("/user/updateForm")
    public String 업데이트(Integer userId) {

        return "user/updateForm";
    }

    @PostMapping("/user/updateForm")
    public String userupdate(Integer userId) {

        return "user/updateForm";
    }
}
