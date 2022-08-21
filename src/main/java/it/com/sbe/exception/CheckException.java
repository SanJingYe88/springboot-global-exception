package it.com.sbe.exception;

/**
 * 自定义参数校验异常类
 */
public class CheckException extends RuntimeException {

    public CheckException(String msg) {
        super(msg);
    }
}
