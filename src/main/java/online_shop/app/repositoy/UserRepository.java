package online_shop.app.repositoy;

import online_shop.app.models.entity.User;
import online_shop.app.models.service.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findFirstByUsername(String username);
}
