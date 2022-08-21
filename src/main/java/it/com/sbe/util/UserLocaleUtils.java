package it.com.sbe.util;

import java.util.Locale;

public class UserLocaleUtils {

    /**
     * 用户语言
     */
    public static ThreadLocal<Locale> langThreadLocal = new ThreadLocal<Locale>() {
        protected Locale initialValue() {
            //默认的Locale
            return Locale.SIMPLIFIED_CHINESE;
        }

        ;
    };

    /**
     * 获取
     *
     * @return Locale
     */
    public static Locale getLang() {
        return langThreadLocal.get();
    }

    /**
     * 设置
     *
     * @param locale locale
     */
    public static void setLang(String locale) {
        UserLocaleUtils.setLang(new Locale(locale));
    }

    /**
     * 设置
     *
     * @param locale locale
     */
    public static void setLang(Locale locale) {
        langThreadLocal.set(locale);
    }

    /**
     * 使用完共享变量后, 将其清除
     */
    public static void clear() {
        langThreadLocal.remove();
    }
}
