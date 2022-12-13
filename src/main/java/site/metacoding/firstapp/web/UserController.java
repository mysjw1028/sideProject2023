package site.metacoding.firstapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.user.User;
import site.metacoding.firstapp.domain.user.UserDao;
import site.metacoding.firstapp.web.dto.user.LoginDto;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final HttpSession session; // 스프링이 서버시작시에 IOC 컨테이너에 보관함.
    private final UserDao userDao;

    @GetMapping("/user/joinForm") // 회원가입
    public String 회원가입페이지() {
        return "user/joinForm";
    }

    @PostMapping("/user/join")
    public String join(User user) {
        System.out.println("디버그" + user.getUserName());
        userDao.insert(user);
        System.out.println("디버그" + user.getUserName());
        return "redirect:/";
    }

    @GetMapping("/user/loginForm")
    public String 로그인페이지() {
        return "user/loginForm";
    }

    @PostMapping("/user/login")
    public String loging(LoginDto loginDto) {
        System.out.println("디버그 : " + loginDto.getUserName());
        User userPS = userDao.login(loginDto);
        System.out.println("디버그 : " + loginDto.getUserName());
        if (userPS != null) {
            System.out.println("디버그 : if직후");
            System.out.println("디버그 : " + loginDto.getUserName());
            session.setAttribute("principal", userPS);
            System.out.println("디버그 : return 직전");
            return "redirect:/";
        } else {// 인증안됨
            return "redirect:/user/loginForm";
        }
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

}
