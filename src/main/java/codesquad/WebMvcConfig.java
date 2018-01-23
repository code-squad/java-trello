package codesquad;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import codesquad.security.BasicAuthInterceptor;
import codesquad.security.LoginUserHandlerMethodArgumentResolver;
import codesquad.security.SecurityLoginCheckInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public BasicAuthInterceptor basicAuthInterceptor() {
		return new BasicAuthInterceptor();
	}

	@Bean
	public SecurityLoginCheckInterceptor securityLoginCheckInterceptor() {
		return new SecurityLoginCheckInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(basicAuthInterceptor());
		registry.addInterceptor(securityLoginCheckInterceptor()).addPathPatterns("/login");
	}

	@Bean
	public LoginUserHandlerMethodArgumentResolver loginUserArgumentResolver() {
		return new LoginUserHandlerMethodArgumentResolver();
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(loginUserArgumentResolver());
	}

}
