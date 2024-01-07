package site.ruise.firstapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;
import site.ruise.firstapp.domain.member.Member;
import site.ruise.firstapp.domain.member.MemberDao;
import site.ruise.firstapp.web.dto.RespDto;
import site.ruise.firstapp.web.dto.member.MemberReqDto;


//회원 서비스
@RequiredArgsConstructor
@Service
public class MemberService {

    final MemberDao memberDao; 
/*서비스 동작 테스트 
    public Map<String, String>  getTest() {
        Map<String,String> res = new HashMap<>();
                res.put("test","hihi");
                System.out.println("test    : " + res );
                return res;
    }
*/
    public void memberInsert(MemberReqDto memberReqDto) {
        memberDao.insert(memberReqDto);
    }
    public void memberUpdate(Integer memberNumber, Member member) {
        memberDao.update(member);
    }
    public void memberDelete(Integer memberNumber, Member member) {
        memberDao.delete(member);
    }

    public Member memberFindById(Integer memberNumber) {
        return memberDao.findById(memberNumber);
    }
    public RespDto<?> memberFindByAll(Model model) {
        List<Member> memberList = memberDao.findAllList();
        model.addAttribute("memberList", memberList);
        return new RespDto<>(1, "성공", memberList);// 타입은 앞에서만 결정
    }
}
