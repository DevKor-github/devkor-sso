package devkor.sso.domain.user;

import devkor.sso.domain.user.dto.UserRequestDto;
import devkor.sso.domain.user.dto.UserResponseDto;
import devkor.sso.global.dto.ApiCallResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequiredArgsConstructor
@RequestMapping(path = "/v1/auth")
@RestController
public class UserApi {
    private final UserService userService;

    @PostMapping(path = "/signup")
    public @Valid ApiCallResponse<UserResponseDto> register(
            @Valid @RequestBody UserRequestDto requestDto
            ) {
        final var user = userService.registerUser(requestDto);

        return ApiCallResponse.ofSuccess(UserResponseDto.of(user));
    }
}
