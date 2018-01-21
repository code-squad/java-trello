package codesquad;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import codesquad.service.SecurityMemberService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger log = LoggerFactory.getLogger(WebSecurityConfig.class);
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Resource(name="securityMemberService")
	private SecurityMemberService securityMemberService;
	
    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity
                .ignoring()
                .antMatchers("/css/**", "/js/**", "/lib/**", "/fonts/**", "/image/**");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.headers().frameOptions().disable();
		
		http
			.authorizeRequests()
			.antMatchers("/", "/create", "/login**", "/logout**")
			.permitAll()
			.antMatchers("/boards/**", "/myboards", "/api/boards", "api/login**", "/api/decks/**", "api/boards/**", "/api/boards/**", "/api/users**")
			.hasRole("USER");
		http.formLogin().loginPage("/login");
		
		http.logout().logoutUrl("/logout").invalidateHttpSession(true);
		
	}
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(securityMemberService).passwordEncoder(passwordEncoder());
	}
	
}
