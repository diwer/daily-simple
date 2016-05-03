package cn.whatisee.core.util;


import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;


/**
 * Created by mingsheng on 16/4/5.
 */
public class QniuUtil {
    private final static Logger logger = Logger.getLogger("QniuUtil");

    private static class SingletonHolder {
        private static final QniuUtil INSTANCE = new QniuUtil();
    }

    public static final QniuUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static QniuUtil instance;
    private Auth auth;

    private QniuUtil() {
        auth = Auth.create(Ak, Sk);
        uploadManager = new UploadManager();
    }

    private final String Ak = "tEG_m4Ral_Y3cSItlYONEaG8VRZR8L30QiRVVRTK";
    private final String Sk = "swDlB-ZrElZsFqilmaiSPnSljLHZlgw-ac9ykg-2";

    private UploadManager uploadManager;

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    private String getUpToken(String buckName) {
        return auth.uploadToken(buckName);
    }


    public boolean uploadByByte(byte[] bytes, String fileName, String buckName) throws IOException {
        try {
            Response res = uploadManager.put(bytes, fileName, getUpToken(buckName));
            logger.info(res.toString());
            return true;
        } catch (QiniuException e) {
            Response r = e.response;
            logger.error(r.toString());
            System.out.println(r.toString());
            return false;
        }
    }

    public boolean uploadByFilePath(String filePath, String fileName, String buckName) throws IOException {
        try {
            Response res = uploadManager.put(filePath, fileName, getUpToken(buckName));
            logger.info(res.toString());
            return true;
        } catch (QiniuException e) {
            Response r = e.response;
            logger.error(r.toString());
            return false;
        }
    }

    public boolean uploadByFile(File file, String fileName, String buckName) throws IOException {
        try {
            Response res = uploadManager.put(file, fileName, getUpToken(buckName));
            logger.info(res.toString());
            return true;
        } catch (QiniuException e) {
            Response r = e.response;
            logger.error(r.toString());
            return false;


        }
    }

}
