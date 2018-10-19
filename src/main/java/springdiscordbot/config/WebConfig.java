package springdiscordbot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@PropertySource({
        "classpath:application.properties"
})
@EnableWebMvc
@ComponentScan(basePackages = "springdiscordbot.core.beans")
public class WebConfig {

    @Bean
    public InternalResourceViewResolver resolver() {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setLocations(new ClassPathResource("application.properties"));
        //propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
        //propertySourcesPlaceholderConfigurer.setIgnoreResourceNotFound(true);
        return propertySourcesPlaceholderConfigurer;
    }

}
