package it.com.sbe.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/*
 * 全局异常错误码实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CodeMsg {

    // 通用的错误码
    public static CodeMsg SUCCESS = new CodeMsg(20000, "成功");
    public static CodeMsg ERROR = new CodeMsg(20001, "错误");
    public static CodeMsg ERROR_REQUEST = new CodeMsg(40000, "非法请求");
    public static CodeMsg NO_PERMISSION = new CodeMsg(40001, "权限不足");
    public static CodeMsg TOKEN_ERROR = new CodeMsg(40002, "token出错");
    public static CodeMsg NOT_FOUND = new CodeMsg(40003, "NOT FOUND");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    public static CodeMsg PARAM_ERROR = new CodeMsg(500101, "参数校验失败");
    public static CodeMsg DUPLICATE_KEY_ERROR = new CodeMsg(500102, "主键冲突,添加失败");
    // Brand模块 5002XX  ( 本次测试所用 )
    public static CodeMsg BRAND_ID_EMPTY = new CodeMsg(500211, "Brand的id不能为空");
    // Book模块 5003XX  ( 本次测试所用 )
    public static CodeMsg BOOK_ID_EMPTY = new CodeMsg(500311, "Book的id不能为空");
    private Integer code;     // 错误码
    private String msg;   // 错误信息
}
