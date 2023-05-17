package devkor.sso.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

/**
 * User
 *
 * @author ryuni
 * @version 1.0.0
 * @since 2023/05/08
 **/

public interface UserRepository extends JpaRepository<Users, UUID> {
    @Query("SELECT u FROM Users u WHERE u.KUPID_email = :email")
    Optional<Users> findByEmail(String email);

    @Query("SELECT u FROM Users u WHERE u.uid = :uid")
    Optional<Users> findById(String uid);
}
