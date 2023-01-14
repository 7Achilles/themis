package com.achilles.themis.client.handler;


import com.achilles.themis.client.vo.ThemisResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ThemisResponse doGlobalExceptionHandler(Exception exception) {
        logger.error(exception.getMessage(),exception);
        if (exception instanceof MethodArgumentNotValidException)
            return ThemisResponse.error(((MethodArgumentNotValidException) exception).getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return ThemisResponse.error(exception.getMessage());
    }


}
