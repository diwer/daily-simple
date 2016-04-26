package cn.whatisee.component.impl;

import cn.whatisee.component.IMailComponent;
import cn.whatisee.config.MailConfig;
import cn.whatisee.core.tool.SpringContextHolder;
import cn.whatisee.core.util.SendMessageUtil;
import cn.whatisee.core.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.Map;

/**
 * Created by mingsheng on 16/4/7.
 */

@Component
public class MailComponentImpl implements IMailComponent {

    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private JavaMailSender mailSender;


    @Override
    public boolean SendSimpleMail(Map<String, Object> map, final String to, final String subject, MailConfig config) {

        String messageContext = SendMessageUtil.getMessageContent(map, config.getVmPath());

        if (StringUtils.isEmpty(messageContext)) {
            logger.error("发送邮件失败:" + to + "内容为空");
            return false;
        }
        SimpleMailMessage message = SpringContextHolder.getBean("SimpleMailMessage");
        message.setTo(to);
        message.setText(messageContext);
        message.setSubject(subject);
        return send(message);

    }


    @Override
    public boolean sendMimeMail(final Map<String, Object> map, final String to, final String subject, final MailConfig config) {


        String messageContext = SendMessageUtil.getMessageContent(map, config.getVmPath());
        if (StringUtils.isEmpty(messageContext)) {
            logger.error("发送邮件失败:" + to + "内容为空");
            return false;
        }
        MimeMailMessage mailMessage = SpringContextHolder.getBean("MimeMailMessage");

        MimeMessageHelper helper = mailMessage.getMimeMessageHelper();
        try {

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(messageContext, true);


        } catch (MessagingException e) {
            logger.debug(e);

            logger.error(String.format("发送邮件失败:to %s type%s", to, config.getName()));
            e.printStackTrace();
        }
        send(mailMessage);
        return true;
    }

    @Override
    public boolean sendMimeMail(Map<String, Object> map, String to, MailConfig config) {
        return sendMimeMail(map, to, "你的日记发送的邮件", config);
    }

    private boolean send(MailMessage message) {
        try {

                if (message instanceof MimeMailMessage) {
                    MimeMailMessage m = (MimeMailMessage) message;
                    this.mailSender.send(m.getMimeMessage());
                }
                if (message instanceof SimpleMailMessage) {
                    SimpleMailMessage m = (SimpleMailMessage) message;
                    this.mailSender.send(m);
                }

            return true;
        } catch (MailException ex) {
            logger.info("邮件发送失败:" + message);
            logger.debug(ex);
            System.err.println(ex.getMessage());
        }
        return false;
    }
}
