package devkor.sso.global.exception;

import devkor.sso.global.dto.ApiResultCode;

/**
 * User
 *
 * @author ryuni
 * @version 1.0.0
 * @since 2023/05/31
 **/

/**
* reference
* https://github.com/mimi-teams/Meezle-Backend/blob/main/src/main/java/com/mimi/w2m/backend/config/exception/BusinessException.java
**/

public class BusinessException extends RuntimeException{
    public final ApiResultCode apiResultCode;
    public final String message;
    public final String messageToClient;

    public BusinessException(String message) {
        super(message);
        this.apiResultCode = ApiResultCode.SERVER_ERROR;
        this.message = message;
        this.messageToClient = apiResultCode.defaultMessage;
    }

    public BusinessException(String message, String messageToClient) {
        super(message);
        this.apiResultCode = ApiResultCode.SERVER_ERROR;
        this.message = message;
        this.messageToClient = messageToClient;
    }

    public BusinessException(String message, String messageToClient, Throwable cause) {
        super(message, cause);
        this.apiResultCode = ApiResultCode.SERVER_ERROR;
        this.message = message;
        this.messageToClient = messageToClient;
    }

    protected BusinessException(ApiResultCode apiResultCode, String message) {
        super(message);
        this.apiResultCode = apiResultCode;
        this.message = message;
        this.messageToClient = apiResultCode.defaultMessage;
    }

    protected BusinessException(ApiResultCode apiResultCode, String message, String messageToClient) {
        super(message);
        this.apiResultCode = apiResultCode;
        this.message = message;
        this.messageToClient = messageToClient;
    }

    protected BusinessException(ApiResultCode apiResultCode, String message, String messageToClient, Throwable cause) {
        super(message, cause);
        this.apiResultCode = apiResultCode;
        this.message = message;
        this.messageToClient = messageToClient;
    }
}
