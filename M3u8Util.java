import com.jinmgr.m3u8.download.M3u8DownloadFactory;
import com.jinmgr.m3u8.utils.Constant;

import java.io.File;
import java.io.Serializable;

/**
 * m3u8下载工具类
 *
 * @author LiuChenghui 2024/03/20 10:34:00
 * @version 1.0
 */
public class M3u8Util {

    public static void main(String[] args) {
        String title = "闻香识女人";
        String url = "https://64.32.20.246/play/pen3RPa7/index.m3u8";
        String baseDir = "D:/douyin";
        downloadM3u8(title, url, baseDir);
    }

    /**
     * 下载m3u8
     *
     * @param title
     * @param url
     * @param baseDir
     * @return
     */
    private static File downloadM3u8(String title, String url, String baseDir) {
        try {
            M3u8DownloadFactory.M3u8Download m3u8Download = M3u8DownloadFactory.getInstance();
            //m3u8文件地址
            m3u8Download.setDOWNLOADURL(url);
            //设置生成目录
            m3u8Download.setDir(baseDir + Constant.FILESEPARATOR + title);
            //设置视频名称
            m3u8Download.setFileName(title);
            //设置线程数
            m3u8Download.setThreadCount(100);
            //设置重试次数
            m3u8Download.setRetryCount(10);
            //设置连接超时时间（单位：毫秒）
            m3u8Download.setTimeoutMillisecond(10000L);
            //添加额外请求头
      /*  Map<String, Object> headersMap = new HashMap<>();
        headersMap.put("Content-Type", "text/html;charset=utf-8");
        m3u8Download.addRequestHeaderMap(headersMap);*/
            //如果需要的话设置http代理
            //m3u8Download.setProxy("172.50.60.3",8090);
            //添加监听器
            //开始下载
            return m3u8Download.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
