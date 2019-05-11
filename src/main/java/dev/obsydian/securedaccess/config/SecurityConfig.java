package dev.obsydian.securedaccess.config;

import dev.obsydian.securedaccess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;

	@Autowired
	private UserService userService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery("select email, password, enabled from users where email=?")
				.authoritiesByUsernameQuery(
						"select u.email, r.role " +
						"from users u " +
						"inner join user_role ur on(u.user_id=ur.user_id) " +
						"inner join roles r on(ur.role_id=r.role_id) where u.email=?")
				.passwordEncoder(passwordEncoder());
	}


	// https for form pages
	// remember me option for 90 days (no payment or identity information on)
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/form/**").permitAll()

			.and()
				.formLogin().loginPage("/signIn").failureUrl("/signIn?error=true").defaultSuccessUrl("/")
			.and()
				.logout().logoutSuccessUrl("/index")
//			.and()
//				.requiresChannel().antMatchers("/form/**").requiresSecure()
			.and()
			.httpBasic();
			//	.realmName("Security Website")
			//.and()
			//.rememberMe().tokenValiditySeconds(7776000);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//		auth.setUserDetailsService(userService);
//		auth.setPasswordEncoder(passwordEncoder());
//		return auth;
//	}



}