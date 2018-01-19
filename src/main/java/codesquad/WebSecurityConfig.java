package codesquad;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger log = LoggerFactory.getLogger(WebSecurityConfig.class);
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http
			.authorizeRequests()
			.antMatchers("/", "/create", "/login**", "/logout**", "api/login**")
			.permitAll()
			.antMatchers("/boards/**", "/myboards", "/api/boards", "/api/decks/**", "api/boards/**", "/api/boards/**", "/api/users**")
			.hasRole("user");
	}
}
