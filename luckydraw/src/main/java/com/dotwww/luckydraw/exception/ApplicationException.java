package com.dotwww.luckydraw.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 保存异常代码和消息
 */

@Getter
@Setter
public class ApplicationException extends RuntimeException{
    private String code;

    public ApplicationException(String code, String message){
        super(message);
        this.code = code;
    }
    public ApplicationException(String code, String message, Throwable cause){
        super(message, cause);
        this.code = code;
    }
}
