package devkor.sso.domain.user.dto;

import devkor.sso.domain.user.Users;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserRequestDto implements Serializable {
//    @Size(min = 1, max = 20)
    @NotNull
    private String name;
    @Email
    private String KUPID_email;

    private String password;

    @Builder
    public UserRequestDto(String name, String KUPID_email, String password) {
        this.name = name;
        this.KUPID_email = KUPID_email;
        this.password = password;
    }

    public void encryptPassword(String BCryptpassword) {
        this.password = BCryptpassword;
    }

    /* DTO -> Entity */
    public Users toEntity() {
        Users user = Users.builder()
                .name(name)
                .password(password)
                .KUPID_email(KUPID_email)
                .build();
        return user;
    }

}
