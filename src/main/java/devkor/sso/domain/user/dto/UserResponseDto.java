package devkor.sso.domain.user.dto;

import devkor.sso.domain.user.Users;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.io.Serializable;
import java.util.UUID;

public class UserResponseDto implements Serializable {
    @NotNull
    private UUID uid;

    @NotNull
    private String name;

    @Email
    @NotNull
    private String KUPID_email;

    @Builder
    public UserResponseDto(UUID uid, String name, String KUPID_email) {
        this.uid = uid;
        this.name = name;
        this.KUPID_email = KUPID_email;
    }

    public static UserResponseDto of(Users user) {
        return UserResponseDto.builder()
                .uid(user.getUid())
                .name(user.getName())
                .KUPID_email(user.getKUPID_email())
                .build();
    }
}
