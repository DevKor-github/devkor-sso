package devkor.sso.global.dto;

import org.springframework.http.HttpStatus;

/**
 * User
 *
 * @author ryuni
 * @version 1.0.0
 * @since 2023/05/31
 **/

/**
 * reference
 * https://github.com/mimi-teams/Meezle-Backend/blob/main/src/main/java/com/mimi/w2m/backend/dto/base/ApiHttpStatus.java
 **/

public enum ApiHttpStatus {
    OK(200),

    BAD_REQUEST(400),
    ILLEGAL_ACCESS(401),
    NOT_FOUND(404),
    DUPLICATED(405),

    ERROR(500),
    ;

    public final int httpStatus;

    ApiHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpStatus toHttpStatus() {
        return HttpStatus.valueOf(httpStatus);
    }
}
