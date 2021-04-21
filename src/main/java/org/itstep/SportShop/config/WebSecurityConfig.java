package org.itstep.SportShop.config;


import org.itstep.SportShop.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        // Потрібен логін із роллю ROLE_ADMIN або ROLE_MANAGER.
        // Якщо ні, він перенаправить на / admin / login.
        http.authorizeRequests()
                .antMatchers("/admin/orderList", "/admin/order", "/admin/accountInfo","/admin/product")//
                .access("hasAnyRole('ROLE_ADMIN')");
        http.authorizeRequests()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403");
        // Конфігурація форми для входу.
        http.authorizeRequests()
                .and()
                .formLogin()
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/admin/login")//
                .defaultSuccessUrl("/admin/accountInfo")//
                .failureUrl("/admin/login?error=true")//
                .usernameParameter("userName")//
                .passwordParameter("password")
        // Конфігурація для сторінки виходу.
        // (Після виходу перехід на Головну сторінку)
                .and()
                .logout()
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/");

    }
}