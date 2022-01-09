package com.example.springsocial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.springsocial.exception.RestAuthenticationEntryPoint;
import com.example.springsocial.security.TokenAuthenticationFilter;
import com.example.springsocial.security.oauth2.OAuth2AuthenticationSuccessHandler;

@Configuration
@EnableGlobalMethodSecurity(
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

    @Bean
    public TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                // What to do if authentication fails
                    .exceptionHandling()
                    .authenticationEntryPoint(new RestAuthenticationEntryPoint())
                .and()
                    .authorizeRequests()
                    .antMatchers("/",
                        "/error",
                        "/favicon.ico",
                        "/**/*.png",
                        "/**/*.gif",
                        "/**/*.svg",
                        "/**/*.jpg",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js")
                    .permitAll()
                    .antMatchers("/auth/**", "/oauth2/**")
                    .permitAll()
                // any other URL as /data is only for authenticated users
                    .anyRequest()
                    .authenticated()
                .and()
                    .oauth2Login()
                    // set up in Google console as URI
                    .redirectionEndpoint()
                    .baseUri("/oauth2/callback/google")
                .and()
                    .successHandler(oAuth2AuthenticationSuccessHandler);

        // Add our custom Token based authentication filter
        http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
