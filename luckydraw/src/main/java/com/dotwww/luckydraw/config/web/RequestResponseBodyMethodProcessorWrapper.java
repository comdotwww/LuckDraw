package com.dotwww.luckydraw.config.web;


import com.dotwww.luckydraw.bean.JSONResponse;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

public class RequestResponseBodyMethodProcessorWrapper implements HandlerMethodReturnValueHandler {

    private final HandlerMethodReturnValueHandler delegate;


    public RequestResponseBodyMethodProcessorWrapper(HandlerMethodReturnValueHandler delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return delegate.supportsReturnType(returnType);
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        // returnValue是Controller请求方法执行完的返回值
        if(!(returnValue instanceof JSONResponse)){//返回值本身就是需要的类型，不进行处理
            JSONResponse jsonResponse = new JSONResponse();
            jsonResponse.setSuccess(true);
            jsonResponse.setData(returnValue);
            returnValue = jsonResponse;
        }
        delegate.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
    }
}
