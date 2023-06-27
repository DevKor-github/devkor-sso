package devkor.sso.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Spring Config 설정
 *
 * @author ryuni
 * @version 1.0.0
 * @since 2023/05/17
 **/

@Configuration
public class SpringConfig {

    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }
}
