package org.example.common.enums;

import org.springframework.http.HttpStatus;

public enum ResponseCode {
    /** Success  **/
    SUCCESS(200,"Success", HttpStatus.OK),





    /** Client errors  **/
    BAD_REQUEST(400, "Bad Request", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED(401, "UNAUTHORIZED", HttpStatus.UNAUTHORIZED),

    INVALID_AUTH(450, "INVALID_CREDENTIALS", HttpStatus.FORBIDDEN),


    /** Server errors **/
    INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);




    private final int code;
    private final String message;
    private final HttpStatus httpStatus;

    ResponseCode(int code, String message, HttpStatus httpStatus){
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
