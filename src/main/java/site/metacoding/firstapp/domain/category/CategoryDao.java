package site.metacoding.firstapp.domain.category;

public interface CategoryDao {

    public void insert(Category category);

    public void findAll(Category category);

    public Category findById(Integer categoryId);

    public int update(Category category);

    public void deleteById(Category category);

}
