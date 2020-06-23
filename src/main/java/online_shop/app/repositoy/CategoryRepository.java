package online_shop.app.repositoy;

import online_shop.app.models.entity.Category;
import online_shop.app.models.entity.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {
    Optional<Category> findFirstByCategoryName(CategoryName name);
}
