package com.fuxiaosong.ilovebing.utils;

import org.junit.Test;

/**
 * @author fuxiaosong
 * @version 0.1.0
 * @since 2016年12月15日
 */
public class DownloadFileUtilsTest {
    @Test
    public void testDownloadImage(){
        DownloadFileUtils.downloadImage("https://www.baidu.com/", "src/main/resources/public/bingimages", "baidutest1.txt");
        DownloadFileUtils.downloadImage("https://www.baidu.com/", "src/main/resources/public/bingimages/", "baidutest2.txt");
    }
}
