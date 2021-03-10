package com.dotwww.luckydraw.config;

import com.dotwww.luckydraw.bean.JSONResponse;
import com.dotwww.luckydraw.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @ControllerAdvice: 方法上可以使用 @ExceptionHandler 处理异常
 * @RestControllerAdvice: 由 @ControllerAdvice 和 @ResponseBody 组成
 */
@ControllerAdvice
@Slf4j
public class ExceptionAdvice {
    // 使用lombok日志日志注解，之后使用log属性来完成日志打印

    // 自定义异常报错错误码和错误消息
    @ExceptionHandler(ApplicationException.class)
    @ResponseBody
    public Object handle_1(ApplicationException e) {
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.setCode(e.getCode());
        jsonResponse.setMessage(e.getMessage());
        log.debug("自定义异常", e);
        return jsonResponse;
    }

    //非自定义异常（英文错误信息，堆栈信息，不能给用户看）：
    // 指定一个错误码，错误消息（未知错误，请联系管理员）
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handle2(Exception e) {
        JSONResponse json = new JSONResponse();
        json.setCode("ERR000");
        json.setMessage("未知错误，请联系管理员");
        log.error("未知错误", e);
        return json;
    }

    public String transfer(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        e.printStackTrace(pw);  // 打印异常堆栈信息到PrintWriter
        return sw.toString();
    }

}
