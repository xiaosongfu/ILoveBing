package com.fuxiaosong.ilovebing.tasks;

import com.fuxiaosong.ilovebing.models.BingResponse;
import com.fuxiaosong.ilovebing.models.Images;
import com.fuxiaosong.ilovebing.plugins.QiNiuCloud;
import com.fuxiaosong.ilovebing.utils.DownloadFileUtils;
import com.fuxiaosong.ilovebing.utils.LogUtils;
import com.google.gson.Gson;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 定时任务
 * 明天凌晨1点下载 Bing 搜索的桌面图片，并保存到本地和七牛云存储
 *
 * @author fuxiaosong
 * @version 0.1.0
 * @since 2016年12月14日
 */
@Component
public class ScheduledTasks {
    //Bing 桌面图片的网络请求地址
    private static final String BING_IMAGE_URL = "http://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1";
    //本地图片保存路径
    private static final String IMAGE_ROOT_PATH = "./"; //"src/main/resources/public/bingimages/";

    /**
     * 1. 获取图片路径
     * 2. 下载图片到本地
     * 3. 将图片上传到七牛云存储
     *
     * 定时任务请参考: http://blog.didispace.com/springbootscheduled/
     * 在线cron生成器：http://cron.qqe2.com/
     */
    @Scheduled(cron="0 0 1 * * *")
    public void fetchAndHandleImage() {
        //1. 获取图片信息
        Images images = fetchBingImage();
        //解析图片 url 和构造文件名
        String url = images.getUrl();
        String fileName = images.getEnddate() + url.substring(url.lastIndexOf("."));

        LogUtils.i("url: " + url);
        LogUtils.i("fileName: " + fileName);

        //2. 保存到本地
        boolean downloadResult = DownloadFileUtils.downloadImage(url, IMAGE_ROOT_PATH, fileName);

        //3. 保存到本地才可以继续上传到七牛云存储
        if(downloadResult){
            QiNiuCloud.uploadToQiNiuCloud(IMAGE_ROOT_PATH + fileName, fileName);
        }
    }

    /**
     * 获取 Bing 搜索每日壁纸的图片信息
     *
     * @return Images 对象
     */
    private Images fetchBingImage() {
        LogUtils.i("开始获取图片信息");

        /*
         * 发起网络请求
         */
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(BING_IMAGE_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String data;
            while ((data = br.readLine()) != null) {
                sb.append(data);
            }
            br.close();
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * 使用Gson解析服务器返回的数据为Response对象
         */
        BingResponse response =  new Gson().fromJson(sb.toString(), BingResponse.class);

        LogUtils.i("获取图片信息完成");

        //返回图片信息
        return response.getImages()[0];
    }
}