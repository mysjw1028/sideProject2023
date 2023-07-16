package site.ruise.firstapp.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.ruise.firstapp.domain.member.memberDao;
import site.ruise.firstapp.web.dto.member.memberReqDto;

//회원 컨트롤러
@RequiredArgsConstructor
@RestController
public class memberController {
    private final memberDao memberDao;

    @PostMapping("/member/insert") // insert -> 데이터에 값넣기-> post로 넣기
    public void MemberInsert(memberReqDto memberReqDto) {
        memberDao.insert(memberReqDto);
    }

}
