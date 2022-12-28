package site.metacoding.firstapp.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.love.Love;
import site.metacoding.firstapp.domain.love.LoveDao;

@RequiredArgsConstructor
@Service
public class PostService {

    private final LoveDao loveDao;

    public void 좋아요취소(Integer loveId) {// 트래잭션 발동 -> 같은게 묶이게 할려고
        loveDao.deleteById(loveId);
    }

    public Love 좋아요(Love love) {
        loveDao.insert(love);// id, usersId, boardsId 완벽하게 동기화 할려면 SELECT를 해서 해야한다,
        return love;
    }
}
