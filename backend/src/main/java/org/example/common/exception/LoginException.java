package org.example.common.exception;

import org.example.common.enums.ResponseCode;

public class LoginException extends Exception{
    ResponseCode responseCode;

    public LoginException(ResponseCode responseCode){
        super();
        this.responseCode = responseCode;
    }
}
