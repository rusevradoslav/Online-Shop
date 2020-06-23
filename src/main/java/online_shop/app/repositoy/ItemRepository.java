package online_shop.app.repositoy;

import online_shop.app.models.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item,String> {
    Optional<Item> findFirstByName(String name);

}
