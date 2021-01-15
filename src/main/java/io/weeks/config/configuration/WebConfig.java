package io.weeks.config.configuration;

import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "io.weeks")
public class WebConfig implements WebMvcConfigurer {

    @Value("${weeks.fileUploadPath}")
    private String resourcesLocation;

    @Value("${weeks.fileUriPath}")
    private String resourcesUri;

    //CORS
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods(
                        HttpMethod.GET.name(),
                        HttpMethod.HEAD.name(),
                        HttpMethod.POST.name(),
                        HttpMethod.PUT.name(),
                        HttpMethod.DELETE.name()
                );
    }

    //외부 리소스 매핑
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(resourcesUri)
                .addResourceLocations("file://" + resourcesLocation);

    }

    @Bean
    public FilterRegistrationBean<XssEscapeServletFilter> filterRegistrationBean() {
        FilterRegistrationBean<XssEscapeServletFilter> filterRegistration = new FilterRegistrationBean<>();
        filterRegistration.setFilter(new XssEscapeServletFilter());
        filterRegistration.setOrder(1);
        filterRegistration.addUrlPatterns("/*");
        return filterRegistration;
    }

}
