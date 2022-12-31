package site.metacoding.firstapp.domain.love;

import java.util.List;

public interface LoveDao {
    public void insert(Love love);

    public List<Love> findAll();

    public void findByDetail(Love love);

    public void findById(Integer loveId);

    public void update(Love love);

    public void deleteById(Integer loveId);
}
