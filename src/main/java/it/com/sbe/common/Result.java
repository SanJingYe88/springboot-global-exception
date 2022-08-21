package it.com.sbe.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 封装返回结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Result {

    private boolean flag;// 是否成功
    private Integer code; // 状态码,200 成功,100 失败
    private String message;// 返回信息
    private Object data;   // 返回数据

    // 成功时,快捷调用
    public static Result success(String message, Object data) {
        return new Result(true, 200, message, data);
    }

    // 失败时可以快捷调用的方法
    public static Result fail(String message, Object data) {
        return new Result(false, 100, message, data);
    }

    // 发生异常时可以快捷调用的方法
    public static Result error(String message) {
        return new Result(false, 100, message, null);
    }

    // 发生异常时可以快捷调用的方法
    public static Result error(CodeMsg codeMsg) {
        return new Result(false, codeMsg.getCode(), codeMsg.getMsg(), null);
    }
}
