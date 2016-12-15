package com.fuxiaosong.ilovebing.utils;

/**
 * 日志打印工具类
 *
 * @author fuxiaosong
 * @version 0.1.0
 * @since 2016年12月14日
 */
public class LogUtils {
    //是否开启调试模式 flag
    private static boolean isDebugMode = false;

    /**
     * 设置是否开启调试模式
     *
     * @param isDebugMode 为true表示开启调试模式，为false表示关闭调试模式
     */
    public static void setIsDebugMode(boolean isDebugMode) {
        LogUtils.isDebugMode = isDebugMode;
    }

    /**
     * INFO level
     *
     * @param logMessage 要打印的信息
     */
    public static void i(String logMessage){
        if(isDebugMode){
            System.out.println("-- " + logMessage);
        }
    }

    /**
     * ERROR level
     *
     * @param logMessage 要打印的信息
     */
    public static void e(String logMessage){
        if(isDebugMode){
            System.out.println("-- " + logMessage);
        }
    }

    /**
     * DEBUG level
     *
     * @param logMessage 要打印的信息
     */
    public static void d(String logMessage){
        if(isDebugMode){
            System.out.println("-- " + logMessage);
        }
    }

    /**
     * INFO level
     *
     * @param tag tag标记
     * @param logMessage 要打印的信息
     */
    public static void i(String tag, String logMessage){
        if(isDebugMode){
            System.out.println(tag + " -- " + logMessage);
        }
    }

    /**
     * ERROR level
     *
     * @param tag tag标记
     * @param logMessage 要打印的信息
     */
    public static void e(String tag, String logMessage){
        if(isDebugMode){
            System.out.println(tag + " -- " + logMessage);
        }
    }

    /**
     * DEBUG level
     *
     * @param tag tag标记
     * @param logMessage 要打印的信息
     */
    public static void d(String tag, String logMessage){
        if(isDebugMode){
            System.out.println(tag + " -- " + logMessage);
        }
    }
}