package site.metacoding.firstapp.domain.love;

public interface LoveDao {
    public void insert(Love love);

    public void findAll(Love love);

    public void findByDetail(Love love);

    public void findById(Love love);

    public void update(Love love);

    public void deleteById(Integer lovesId);
}
