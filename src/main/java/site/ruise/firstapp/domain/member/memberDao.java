package site.ruise.firstapp.domain.member;

import java.util.List;

import site.ruise.firstapp.web.dto.member.memberReqDto;

public interface memberDao {
    public void insert(memberReqDto memberReqDto); // 회원추가

    public member findById(Integer memberId);//해당 아이디 검색

    public List<member> findAllList();//해당 아이디 검색

    public void update(member member);//해당 아이디 수정

    public void delete(member member);//해당 아이디 삭제


}
