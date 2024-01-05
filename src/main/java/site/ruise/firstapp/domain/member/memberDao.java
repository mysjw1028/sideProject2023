package site.ruise.firstapp.domain.member;

import java.util.List;

import site.ruise.firstapp.web.dto.member.MemberReqDto;

public interface MemberDao {
    public void insert(MemberReqDto memberReqDto); // 회원추가

    public Member findById(Integer memberId);//해당 아이디 검색

    public List<Member> findAllList();//해당 아이디 검색

    public void update(Member member);//해당 아이디 수정

    public void delete(Member member);//해당 아이디 삭제


}
