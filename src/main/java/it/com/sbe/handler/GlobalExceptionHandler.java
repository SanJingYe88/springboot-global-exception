package it.com.sbe.handler;

import it.com.sbe.common.CodeMsg;
import it.com.sbe.common.Result;
import it.com.sbe.exception.CheckException;
import it.com.sbe.exception.ServiceException;
import it.com.sbe.util.UserLocaleUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类.
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    // 处理所有接口数据验证异常
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.info("handleMethodArgumentNotValidException");
        e.printStackTrace();
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        log.info("message:{}", message);
        CodeMsg codeMsg = new CodeMsg(100, message);
        return Result.error(codeMsg);
    }

    // 处理请求路径没映射上的异常
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public Result httpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.info("httpMessageNotReadableException");
        e.printStackTrace();
        return Result.error(CodeMsg.ERROR_REQUEST);
    }

    // 处理主键冲突异常
    @ExceptionHandler(value = DuplicateKeyException.class)
    public Result handleDuplicateKeyException() {
        log.info("handleDuplicateKeyException");
        return Result.error(CodeMsg.DUPLICATE_KEY_ERROR);
    }

    // 处理所有业务异常
    @ExceptionHandler(value = ServiceException.class)
    public Result handlerBrandException(ServiceException e) {
        e.printStackTrace();
        return Result.error(e.getCodeMsg());
    }

    // 处理所有检测异常
    @ExceptionHandler(value = CheckException.class)
    public Result handleCheckException(CheckException e) {
        log.info("handleCheckException");
        e.printStackTrace();
        CodeMsg codeMsg = new CodeMsg(100, e.getMessage());
        //清除语言
        UserLocaleUtils.clear();
        return Result.error(codeMsg);
    }

    // 处理所有的运行时异常
    @ExceptionHandler(value = RuntimeException.class)
    public Result handlerRuntimeException(RuntimeException e) {
        log.info("handlerRuntimeException");
        e.printStackTrace();
        return Result.error(e.getMessage());
    }

    // 处理其他异常(比如系统异常 : 数据库连接不上, 数据库连接超时等)
    @ExceptionHandler(value = Exception.class)
    public Result handlerException(Exception e) {
        log.info("handlerException");
        e.printStackTrace();
        return Result.error(CodeMsg.SERVER_ERROR);
    }
}
