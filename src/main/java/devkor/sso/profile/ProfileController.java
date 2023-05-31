package devkor.sso.profile;

import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@RequiredArgsConstructor
@RestController
public class ProfileController {
    private final Environment env;
    private final Logger log = (Logger) LoggerFactory.getLogger(this.getClass().getSimpleName());
    @GetMapping("/profile")
    public String getProfile() {
        List<String> profiles = Arrays.asList(env.getActiveProfiles());
        log.info(profiles.toString());
        List<String> deployProfiles = Arrays.asList("blue", "green");
        String defaultProfile = profiles.isEmpty() ? "default" : profiles.get(0);
        log.info(profiles.stream()
                .filter(deployProfiles::contains)
                .findAny()
                .orElse(defaultProfile));
        return profiles.stream()
                .filter(deployProfiles::contains)
                .findAny()
                .orElse(defaultProfile);
    }
}
