package site.metacoding.firstapp.web.dto.post;

public class PostpagingDto { // (= 0)
    private Integer totalCount;// (=23)
    private Integer totalPage; // (=3) 23 / 한페이지당 개수 -> 10으로 나누면 된다.
    private Integer currentPage; // 현재 몇 페이지 있는지
    private boolean isLast;// false
    private boolean isFirst;// ture
}// isLast / isFirst는 페이지마다 다르게 false & true이런식으로 해야한다private Integer startNum;
