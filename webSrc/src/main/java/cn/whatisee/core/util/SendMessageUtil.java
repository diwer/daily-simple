package cn.whatisee.core.util;

import cn.whatisee.core.tool.SpringContextHolder;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.mail.MailException;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.util.Map;

/**
 * Created by mingsheng on 16/4/7.
 */
public class SendMessageUtil {


    private static MailMessage msg;


    private static Logger logger = Logger.getLogger(SendMessageUtil.class);

    public static String getMessageContent(Map<String, Object> map, String vmtype) {

        try {

            VelocityEngine engine = new VelocityEngine();
            engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
            engine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
            engine.init();
            String str = VelocityEngineUtils.mergeTemplateIntoString(engine, vmtype, "UTF-8", map);
            System.out.print(str);
            return str;
        } catch (Exception ex) {
            logger.debug(ex);

            logger.info("消息组装失败失败:" + map + vmtype);
            return "";
        }

    }


}
