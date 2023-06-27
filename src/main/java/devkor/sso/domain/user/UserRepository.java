package devkor.sso.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    @Query("SELECT u FROM Users u WHERE u.KUPID_email = :KUPID_email")
    Optional<Users> findByEmail(@Param("KUPID_email") String KUPID_email);

    @Query("SELECT u FROM Users u WHERE u.uid = :uid")
    Optional<Users> findById(@Param("uid") String uid);
}
