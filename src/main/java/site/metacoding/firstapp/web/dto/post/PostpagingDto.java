package site.metacoding.firstapp.web.dto.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostpagingDto { // (= 0)
    private Integer totalCount;// (=23)
    private Integer totalPage; // (=3) 23 / 한페이지당 개수 -> 10으로 나누면 된다.
    private Integer currentPage; // 현재 몇 페이지 있는지
    private boolean isLast;// false
    private boolean isFirst;// ture

}// isLast / isFirst는 페이지마다 다르게 false & true이런식으로 해야한다private Integer startNum;
 // boolean은 의문문으로 만들어서
 // getter가 만들어지면서 isFirst()이름으로 만들어짐 -> el에서는 fiest로 찾아짐 - > boolean타입이라서