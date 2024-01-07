package site.ruise.firstapp.web.dto.member;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberReqDto {
    private Integer memberNumber; // 회원 고유번호
    private String memberId; // 회원 아이디
    private String memberPassword; // 사용자 비밀번호
    private String memberTel;// 사용자 전화번호
    private String memberJumin;// 사용자 주민번호
    private String memberGender;// 사용자 성별
    private String memberNickName;// 사용자 닉네임
    private String memberPostCode;// 사용자 우편주소
    private String memberAdress1;// 사용자 주소
    private String memberAdress2;// 사용자 상세주소
    private String memberState;// 사용자 상태 Y(회원), N(탈퇴회원)
    private Timestamp createDate;// 생성일
    private Timestamp updateDate;// 수정일
    private Timestamp deleteDate;// 삭제일
}
