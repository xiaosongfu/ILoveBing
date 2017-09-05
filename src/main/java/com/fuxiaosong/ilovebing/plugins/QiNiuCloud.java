package com.fuxiaosong.ilovebing.plugins;

import com.fuxiaosong.ilovebing.utils.LogUtils;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

/**
 * 将文件上传到七牛云存储
 *
 * @author fuxiaosong
 * @version 0.1.0
 * @since 2016年12月15日
 */
public class QiNiuCloud {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    private static final String ACCESS_KEY = "";
    private static final String SECRET_KEY = "";
    //要上传的空间
    private static final String BUCKET_NAME = "";

    /**
     * 将文件上传到七牛云存储
     *
     * @param uploadFile 要上传的文件
     * @param fileName 上传到七牛后保存的文件名
     */
    public static void uploadToQiNiuCloud(String uploadFile, String fileName) {
        if ("".equals(ACCESS_KEY) || "".equals(SECRET_KEY) || "".equals(BUCKET_NAME)) {
            //密钥配置
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

            //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
            Zone zone = Zone.autoZone();
            Configuration configuration = new Configuration(zone);

            //创建上传对象
            UploadManager uploadManager = new UploadManager(configuration);

            try {
                // 获取 uploadToken
                String uploadToken = auth.uploadToken(BUCKET_NAME);
                //调用put方法上传
                Response res = uploadManager.put(uploadFile, fileName, uploadToken);
                //打印返回的信息
                LogUtils.i("QiNiuCloud", res.bodyString());
            } catch (QiniuException e) {
                Response r = e.response;
                // 请求失败时打印的异常的信息
                LogUtils.i("QiNiuCloud", r.toString());
                try {
                    //响应的文本信息
                    LogUtils.i("QiNiuCloud", r.bodyString());
                } catch (QiniuException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
