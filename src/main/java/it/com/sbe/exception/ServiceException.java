package it.com.sbe.exception;

import it.com.sbe.common.CodeMsg;
import lombok.Data;

/*
 * 自定义业务异常类
 */
@Data
public class ServiceException extends RuntimeException {

    private CodeMsg codeMsg;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(CodeMsg codeMsg) {
        super(codeMsg.getMsg());
    }
}
