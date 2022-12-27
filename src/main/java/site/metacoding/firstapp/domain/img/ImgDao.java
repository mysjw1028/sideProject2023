package site.metacoding.firstapp.domain.img;

public interface ImgDao {
    public void save(Img img);

    public void update();

    public Img findById(Integer id);
}
