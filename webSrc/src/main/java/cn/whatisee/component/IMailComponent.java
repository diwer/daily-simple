package cn.whatisee.component;

import cn.whatisee.config.MailConfig;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.MessagingException;
import java.util.Map;

/**
 * Created by mingsheng on 16/4/7.
 */
public interface IMailComponent {

    boolean SendSimpleMail(Map<String, Object> map, String to, String subject, MailConfig config);

    boolean sendMimeMail(Map<String, Object> map, String to, String subject, MailConfig config);

    boolean sendMimeMail(Map<String, Object> map, String to, MailConfig config);
}
