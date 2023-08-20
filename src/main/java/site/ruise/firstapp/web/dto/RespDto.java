package site.ruise.firstapp.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class RespDto <T>{//데이터 트랜스 오브젝트
	private Integer code; // 1정상 -1 실패
	private String msg;//통신에 대한 결과 메세지 담기
	private T body;
}