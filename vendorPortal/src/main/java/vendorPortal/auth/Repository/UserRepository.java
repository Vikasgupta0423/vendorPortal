package vendorPortal.auth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vendorPortal.auth.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
}
