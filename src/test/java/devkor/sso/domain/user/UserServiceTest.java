package devkor.sso.domain.user;

import devkor.sso.domain.user.dto.UserRequestDto;
import devkor.sso.global.exception.BusinessException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Optional;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    private String name;

    private String email;

    private String password;

    @BeforeEach
    void setUp() {
        name = "test";
        email = "test@korea.ac.kr";
        password = "1234";
    }

    @Test
    void testRegisterUser() {
        // given
        UserRequestDto requestDto = new UserRequestDto(name, email, password);
        String requestPassword = requestDto.getPassword();
        // when
        Users savedUser = userService.registerUser(requestDto);


        // then
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getKUPID_email()).isEqualTo(requestDto.getKUPID_email());
        assertThat(encoder.matches(requestPassword, savedUser.getPassword())).isTrue();
    }

    @Test
    void testGetUserByEmail() {
        // given
        Users user = new Users(name, email, password);
        userRepository.save(user);

        // when
        Optional<Users> foundUser = userService.getUserByEmail(user.getKUPID_email());

        // then
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getUid()).isEqualTo(user.getUid());
        assertThat(foundUser.get().getKUPID_email()).isEqualTo(user.getKUPID_email());
        assertThat(foundUser.get().getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    void testGetUserByEmail_NotFound() {
        // when
        Optional<Users> foundUser = userService.getUserByEmail("notExist@example.com");

        // then
        assertThat(foundUser).isEmpty();
    }

    @Test
    void testRegisterUser_DuplicateEmail() {
        // given
        Users user = new Users(name, email, password);
        userRepository.save(user);

        UserRequestDto requestDto = new UserRequestDto(name, email, password);

        // when
        assertThatThrownBy(() -> userService.registerUser(requestDto))
                .isInstanceOf(BusinessException.class)
                .hasMessageContaining(requestDto.getKUPID_email());
    }
}