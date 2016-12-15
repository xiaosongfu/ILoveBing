package com.fuxiaosong.ilovebing.plugins;

import org.junit.Test;

/**
 * @author fuxiaosong
 * @version 0.1.0
 * @since 2016年12月15日
 */
public class QiNiuCloudTest {
    @Test
    public void testUploadToQiNiuCloud(){
        QiNiuCloud.uploadToQiNiuCloud("src/main/resources/public/bingimages/20161215.jpg", "20161215.jpg");
    }
}