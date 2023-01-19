package site.metacoding.firstapp.web.dto.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostPagingDto { // (= 0)
    private String keyword;
    private Integer blockCount; // 상수 한페이지에 페이지 넘수 개수(5) 1-5, 6-10
    private Integer currentBlock; // 변수
    private Integer startPageNum; // 변수 1 -> 6 -> 11
    private Integer lastPageNum; // 변수 5 -> 10 -> 15
    private Integer totalCount;
    private Integer totalPage;// (=3) 23 / 한페이지당 개수 -> 10으로 나누면 된다.
    private Integer currentPage; // 현재 몇 페이지 있는지
    private boolean isLast; // getter가 만들어지면 isLast() 이름으로 만들어짐. -> el에서는 last로 찾음
    private boolean isFirst; // getter가 만들어지면 isFirst() 이름으로 만들어짐. -> el에서는 first로 찾음

    public void makeBlockInfo(String keyword, Integer userId) {
        this.keyword = keyword;
        this.blockCount = 5;

        this.currentBlock = currentPage / blockCount;
        this.startPageNum = 1 + blockCount * currentBlock;
        this.lastPageNum = 5 + blockCount * currentBlock;

        if (totalPage < lastPageNum) {
            this.lastPageNum = totalPage;
        }
    }

}// isLast / isFirst는 페이지마다 다르게 false & true이런식으로 해야한다private Integer startNum;
 // boolean은 의문문으로 만들어서
 // getter가 만들어지면서 isFirst()이름으로 만들어짐 -> el에서는 fiest로 찾아짐 - > boolean타입이라서