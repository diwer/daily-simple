package cn.whatisee.web;

import cn.whatisee.core.util.ImageUtil;
import cn.whatisee.core.util.StringUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by mingsheng on 16/4/29.
 */
public class ImageServlet extends HttpServlet {

    private static final long serialVersionUID = -3863715662265394731L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
//        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
//        response.setHeader("Cache-Control", "no-cache");
//        response.setDateHeader("Expire", 0);
//        String valiCode=StringUtils.getRandomString(4);
//
//        try {
//            ImageIO.write(ImageUtil.getRandcode(valiCode),"jpg",response.getOutputStream());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}