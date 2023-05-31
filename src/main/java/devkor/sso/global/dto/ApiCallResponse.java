package devkor.sso.global.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Objects;

/**
 * User
 *
 * @author ryuni
 * @version 1.0.0
 * @since 2023/05/31
 **/

/**
 * reference
 * https://github.com/mimi-teams/Meezle-Backend/blob/main/src/main/java/com/mimi/w2m/backend/dto/base/ApiCallResponse.java
 **/

@Getter
public class ApiCallResponse<T> implements Serializable {
    @NotNull
    private final ApiResultCode code;

    @NotNull
    private final String message;

    @Valid
    @Nullable
    private final T data;

    private ApiCallResponse(ApiResultCode code, String message, T data) {
        this.code = code;
        this.message = (Objects.isNull(message) || message.isEmpty()) ? code.defaultMessage : message;
        this.data = data;
    }


    public static <T> ApiCallResponse<T> ofSuccess(T data) {
        return new ApiCallResponse<>(ApiResultCode.SUCCESS, null, data);
    }

    @SuppressWarnings("unused")
    public static <T> ApiCallResponse<T> of(ApiResultCode code, T data) {
        return new ApiCallResponse<>(code, null, data);
    }

    @SuppressWarnings("unused")
    public static <T> ApiCallResponse<T> of(ApiResultCode code, String message, T data) {
        return new ApiCallResponse<>(code, message, data);
    }

    public static Class<?> getGenericClass(Type genericType) {
        return null;
    }

}
