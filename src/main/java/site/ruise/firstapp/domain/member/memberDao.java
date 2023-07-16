package site.ruise.firstapp.domain.member;

import site.ruise.firstapp.web.dto.member.memberReqDto;

public interface memberDao {
    public void insert(memberReqDto memberReqDto);

    public member findById(Integer memberId);
}
