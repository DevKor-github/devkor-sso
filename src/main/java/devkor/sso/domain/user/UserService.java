package devkor.sso.domain.user;

import devkor.sso.domain.user.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * User
 *
 * @author ryuni
 * @version 1.0.0
 * @since 2023/05/17
 **/

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final Logger logger = LoggerFactory.getLogger(UserService.class.getName());

    public Optional<Users> getUserByEmail(String email)  {
        return userRepository.findByEmail(email);
    }

    protected Users registerUser(UserRequestDto requestDto) {
        if (getUserByEmail(requestDto.getKUPID_email()).isPresent()) {
//            throw new (String.format("이미 등록된 KUPID 이메일입니다: email=%s", requestDto.getKUPID_email());
        }
        requestDto.encryptPassword(encoder.encode(requestDto.getPassword()));
        final var user = userRepository.save(requestDto.toEntity());
        logger.info("Success Signup Service");

        return user;
    }
}
