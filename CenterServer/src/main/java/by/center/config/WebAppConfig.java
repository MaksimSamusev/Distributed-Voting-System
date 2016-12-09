package by.center.config;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("by.center")
public class WebAppConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		// resolver.setPrefix("/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);

		return resolver;
	}

	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver() {
			@Override
			public boolean isMultipart(HttpServletRequest request) {
				String method = request.getMethod().toLowerCase();
				// By default, only POST is allowed. Since this is an 'update'
				// we should accept PUT.
				if (!Arrays.asList("put", "post").contains(method)) {
					return false;
				}
				String contentType = request.getContentType();
				return (contentType != null && contentType.toLowerCase().startsWith("multipart/"));
			}
		};
	}
}
