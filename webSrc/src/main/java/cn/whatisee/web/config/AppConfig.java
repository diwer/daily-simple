package cn.whatisee.web.config;

import freemarker.template.utility.XmlEscape;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mingsheng on 16/4/25.
 */
@Configuration("/spring-mvc.xml")
public class AppConfig extends WebMvcConfigurerAdapter{
    @Bean(name ="freemarkerConfig")
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/WEB-INF/views/");
        Map<String, Object> map = new HashMap<>();
        map.put("xml_escape", new XmlEscape());
        configurer.setDefaultEncoding("utf-8");
        configurer.setFreemarkerVariables(map);
        return configurer;
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.ignoreUnknownPathExtensions(false).defaultContentType(MediaType.TEXT_HTML);
    }
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

//        registry.freeMarker();//.attributes("contentType","text/html;charset=UTF-8");

    }
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer){

       // configurer.
    }
}
