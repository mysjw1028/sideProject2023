package site.ruise.firstapp.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.ruise.firstapp.domain.member.Member;
import site.ruise.firstapp.service.MemberService;
import site.ruise.firstapp.web.dto.RespDto;
import site.ruise.firstapp.web.dto.member.MemberReqDto;


//회원 컨트롤러
@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member/insert") // insert -> 데이터에 값넣기-> post로 넣기
    public void MemberInsert(MemberReqDto memberReqDto) {
        //memberDao.insert(memberReqDto);
        memberService.memberInsert(memberReqDto);
    }

    @GetMapping("/member/{memberNumber}") // 1번 findById -> 상세보기
    public Member findById(@PathVariable Integer memberNumber) {
        //return memberDao.findById(memberId);
        return memberService.memberFindById(memberNumber);
    }

    @GetMapping("/member/memberList") // 2번 findAll -> 전체보기
    public RespDto<?> findAll(Model model) {
        //List<Member> memberList = memberDao.findAllList();
        //model.addAttribute("memberList", memberList);
        // return new RespDto<>(1, "성공", memberList);
        RespDto<?>memberAll = memberService.memberFindByAll(model);// 타입은 앞에서만 결정
        return new RespDto<>(1, "성공", memberAll);
    }

    @PostMapping("/member/{memberNumber}/update") // 4번 update -> 수정하기 -> post로 값 수정
    public void update(@PathVariable Integer memberNumber, Member member) {
        memberService.memberUpdate(memberNumber,member);
    }

    @PostMapping("/member/{memberId}/delete") // 4번 update -> 수정하기 -> post로 값 수정
    public void delete(@PathVariable Integer memberNumber, Member member) {
        //memberDao.delete(member);
        memberService.memberDelete(memberNumber,member);
    }
}
/*서비스 동작테스트 
    @GetMapping("/test")
    public Map<String, String>  jsonTest() {
        Map<String,String> res = this.memberService.getTest();
        return res;
    }
*/

