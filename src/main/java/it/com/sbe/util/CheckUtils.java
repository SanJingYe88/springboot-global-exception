package it.com.sbe.util;

import it.com.sbe.exception.CheckException;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 校验工具类
 */
@Slf4j
public class CheckUtils {

    public static final String CHECK_PARAM_DEFAULT_MSG = "缺少指定参数";

    /**
     * 其他的条件判断, 使用默认的 message
     *
     * @param condition 要检测的条件
     * @param args      同时将检测的参数也传递过来
     */
    public static void check(boolean condition, Object... args) {
        CheckUtils.check(condition, CHECK_PARAM_DEFAULT_MSG, args);
    }

    /**
     * 其他的条件判断
     *
     * @param condition 要检测的条件
     * @param msg       检测不通过的错误消息
     * @param args      同时将检测的参数也传递过来
     */
    public static void check(boolean condition, String msg, Object... args) {
        if (!condition) {       //检测不通过
            fail(msg, args);
        }
    }

    /**
     * 对象判断 null, 使用默认的 msg
     *
     * @param obj
     * @param args
     */
    public static void notNullObj(Object obj, Object... args) {
        notNull(obj, CHECK_PARAM_DEFAULT_MSG, args);
    }

    /**
     * 对象判断 null, 使用自定义的 msg
     *
     * @param obj
     * @param msg
     * @param args
     */
    public static void notNull(Object obj, String msg, Object... args) {
        if (obj == null) {
            fail(msg, args);
        }
    }

    /**
     * 字符串判断 null, 判断空
     *
     * @param str
     * @param args
     */
    public static void notNullEmptyParam(String str, Object... args) {
        notNullEmpty(str, CHECK_PARAM_DEFAULT_MSG, args);
    }


    /**
     * 字符串判断 null, 判断空
     *
     * @param str
     * @param msg
     * @param args
     */
    public static void notNullEmpty(String str, String msg, Object... args) {
        if (str == null || str.trim().length() == 0) {
            fail(msg, args);
        }
    }

    /**
     * 检测失败的处理方法
     *
     * @param msg
     * @param args
     */
    public static void fail(String msg, Object... args) {
        String result = msg + ":" + Arrays.asList(args);
        log.info("{}", result);
        //获取用户的语言
        Locale locale = UserLocaleUtils.getLang();
        throw new CheckException(CheckUtils.get(msg, locale));
    }

    /**
     * 从i18n文件中获取
     *
     * @param msg    key
     * @param locale 语言
     * @return 对应语言文件的对应key的value
     */
    public static String get(String msg, Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("res.MessageBundle", locale);
        if (resourceBundle == null) {    // 不存在 i18n, 原样输出
            return msg;
        }
        return resourceBundle.getString(msg);
    }
}
