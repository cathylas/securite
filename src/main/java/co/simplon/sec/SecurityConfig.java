package co.simplon.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

     /* auth.inMemoryAuthentication()
              .withUser("admin").password("1234").roles("ADMIN","USER")
              .and()
              .withUser("user").password("1234").roles("USER");*/
     auth.userDetailsService(userDetailsService)
     .passwordEncoder(getEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.formLogin();
        http.authorizeRequests().antMatchers("login/**","/register/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/task/**").hasAuthority("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
    }
}
