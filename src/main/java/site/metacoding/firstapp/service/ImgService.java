package site.metacoding.firstapp.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.firstapp.domain.img.Img;
import site.metacoding.firstapp.domain.img.ImgDao;

@RequiredArgsConstructor
@Service
public class ImgService {

    private final ImgDao imgDao;

    public void 사진저장(Img img) {

        imgDao.save(img);
    }

    public Img 아이디로사진찾기(Integer id) {
        Img img = imgDao.findById(id);
        return img;
    }
}
