package com.spring.rest.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http
            .authorizeRequests()
                .antMatchers(
                        "/api/user-authentication/**",
                        "/api/activate-user/**",
                        "/api/activate-user-new/**",
                        "/api/userSignUp/**",
                        "/swagger-ui/swagger-ui.css",
                        "/v3/api-docs/swagger-config",
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/swagger-ui.html",
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/v2/api-docs"
                ).permitAll()
                .anyRequest().authenticated()
            .and()
            .httpBasic().disable();   // DISABLE BASIC AUTH (important)

        // REGISTER YOUR JWT FILTER
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}