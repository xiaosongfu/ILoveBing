![你看不到我^_^](http://xiaosongfu-github.nos-eastchina1.126.net/ilovebing.jpg)

---  

>  
项目结构简单粗暴，文件数量寥寥几个   *--尼古拉斯赵四*  

**喜欢 Bing 的每日壁纸吗？运行该项目她们就都是你的了^_^**  

## #1 功能：  
1. 每天凌晨1点钟自动获取 Bing 的每日壁纸  
2. ~~并将图片保存在图中3所标识的位置，文件名为当日日期~~ 如果是在 IDE 里运行项目，则图片保存在项目根目录，如果是打成 jar 包运行，则是保存到 jar 包所在目录  
3. 若配置好七牛云，也会将图片上传到七牛云服务器，文件名亦为当日日期  

## #2 配置七牛云：  
打开图中1所标识的 QiNiuCloud.java 文件，配置好 ACCESS_KEY 、SECRET_KEY、BUCKET_NAME 即可。  

## #3 运行项目  
该项目基于 Spring Boot 构建，IDE 为 IntelliJ IDEA 2016社区板。导入项目后需先安装依赖，然后配置好七牛云存储服务的信息(可选)，最后运行图中3所标识的 ILoveBingApplication.java 文件即可。  
当然更多的是希望将项目打成一个 jar 包或者 war 包，然后放到服务器上运行，打成 jar 包的方法可参考：[IntelliJ-IDEA-打包-Spring-Boot-项目为-jar-包](https://fuxiaosong.cn/2016/12/15/IntelliJ-IDEA-打包-Spring-Boot-项目为-jar-包/)  

## #4 Over
欢迎提issue，提PR。
