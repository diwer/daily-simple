import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by ming on 16/7/25.
 */
public class test {
    public static void main(String[]args){
        ApplicationContext context=new FileSystemXmlApplicationContext("classpath:spring-session.xml");
        JedisConnectionFactory factory=(JedisConnectionFactory) context.getBean("jedisConnectionFactory");
      RedisConnectionFactory repository=(RedisConnectionFactory) context.getBean(RedisConnectionFactory.class);
        System.out.print("success");
    }
}
