package devkor.sso.domain.user;

import devkor.sso.domain.user.dto.UserRequestDto;
import devkor.sso.domain.user.dto.UserResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequiredArgsConstructor
@RequestMapping(path = "/v1/user")
@RestController
public class UserApi {
    private final UserService userService;

    @PostMapping(path = "/signup")
    public @Valid UserResponseDto register(
            @Valid @RequestBody UserRequestDto requestDto
            ) {
        final var user = userService.registerUser(requestDto);

        return UserResponseDto.of(user);
    }
}
