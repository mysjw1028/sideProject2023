package site.ruise.firstapp.web;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.ruise.firstapp.domain.member.member;
import site.ruise.firstapp.domain.member.memberDao;
import site.ruise.firstapp.web.dto.RespDto;
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

    @GetMapping("/member/{memberId}") // 1번 findById -> 상세보기
	public member 상세보기(@PathVariable Integer memberId) {
		return memberDao.findById(memberId);
	}

 @GetMapping("/member/memberList") // 2번 findAll -> 전체보기
	public RespDto<?> findAll(Model model) {
        List<member> memberList = memberDao.findAllList();
        model.addAttribute("memberList",memberList);
        return new RespDto<>(1,"성공",memberList);//타입은 앞에서만 결정
    }

	@PostMapping("/member/{memberId}/edit") // 4번 update -> 수정하기 -> post로 값 수정
    public void update(@PathVariable Integer memberId, member member) {
		memberDao.update(member);
		System.out.println(memberId);//해당 아이디 숫자 출력됨
	}

    @PostMapping("/member/{memberId}/delete") // 4번 update -> 수정하기 -> post로 값 수정
    public void delete(@PathVariable Integer memberId, member member) {
		memberDao.delete(member);
		System.out.println(memberId);//해당 아이디 숫자 출력됨
	}



}

