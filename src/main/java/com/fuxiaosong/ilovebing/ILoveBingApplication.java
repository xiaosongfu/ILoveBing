package com.fuxiaosong.ilovebing;

import com.fuxiaosong.ilovebing.utils.LogUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * ILoveBingApplication
 * 项目运行入口
 *
 * @author fuxiaosong
 * @version 0.1.0
 * @since 2016年12月14日
 */
@SpringBootApplication
@EnableScheduling
public class ILoveBingApplication {
    public static void main(String[] args){
        //开启调试模式
        LogUtils.setIsDebugMode(true);
        //run
        SpringApplication.run(ILoveBingApplication.class , args);
    }
}