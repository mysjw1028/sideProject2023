package site.metacoding.firstapp.domain.category;

public interface CategoryDao {

    public void insert(Category category);

    public void findAll(Category category);

    public void findById(Category category);

    public void update(Category category);

    public void deleteById(Category category);

}
