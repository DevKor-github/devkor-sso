package devkor.sso.domain.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

/**
 * User
 *
 * @author ryuni
 * @version 1.0.0
 * @since 2023/05/08
 **/

@Getter
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "uid", columnDefinition = "BYTEA")
    private UUID uid;

//    @Comment("사용자 비밀번호")
    @Column(name = "password")
    private String password;

//    @Comment("사용자 이름 (중복 가능)")
    @Column(name = "name", length = 200, nullable = false)
    private  String name;

//    @Comment("KUPID email")
    @Column(name = "KUPID_email", nullable = false, unique = true)
    private String KUPID_email;

    @Builder
    public Users(String name, String KUPID_email, String password) {
        this.name = name;
        this.KUPID_email = KUPID_email;
        this.password = password;
    }
}
