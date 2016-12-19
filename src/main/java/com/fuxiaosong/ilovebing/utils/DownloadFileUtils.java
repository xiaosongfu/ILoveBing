package com.fuxiaosong.ilovebing.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 下载文件工具类
 *
 * @author fuxiaosong
 * @version 0.1.0
 * @since 2016年12月15日
 */
public class DownloadFileUtils {
    /**
     * 下载文件
     *
     * @param fileNetworkUrl 文件的网络地址
     * @param fileSavePath 本地保存路径，包不包含 / 都可以
     * @param fileSaveName 本地保存的文件名
     */
    public static boolean downloadImage(String fileNetworkUrl, String fileSavePath, String fileSaveName) {
        LogUtils.i("开始下载文件");

        //保存的结果，默认为成功
        boolean downloadResult = true;

        try {
            URL url = new URL(fileNetworkUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            // 输入流
            InputStream in = con.getInputStream();
            // 读取到的数据长度
            OutputStream out;
            if(fileSavePath.endsWith(File.separator)){
                out = new FileOutputStream(fileSavePath + fileSaveName);
            }else{
                out = new FileOutputStream(fileSavePath + File.separator + fileSaveName);
            }
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 开始读取
            int len;
            while ((len = in.read(bs)) != -1) {
                out.write(bs, 0, len);
            }
            // 完毕，关闭所有链接
            out.close();
            in.close();
            con.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            //保存失败
            downloadResult = false;
        } catch (IOException e) {
            e.printStackTrace();
            //保存失败
            downloadResult = false;
        }

        LogUtils.i("下载并保存文件成功");

        //返回保存结果
        return downloadResult;
    }
}