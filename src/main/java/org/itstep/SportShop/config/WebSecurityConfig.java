package org.itstep.SportShop.config;

import org.itstep.SportShop.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    final
    UserDetailsServiceImpl userDetailsService;

    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // Установки пошуку користувача
        // І встановлення PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        // Потрібен логін із роллю ROLE_EMPLOYEE або ROLE_MANAGER.
        // Якщо ні, він перенаправить на / admin / login.
        http.authorizeRequests().antMatchers("/admin/orderList", "/admin/order", "/admin/accountInfo")//
                .access("hasAnyRole('ROLE_EMPLOYEE', 'ROLE_MANAGER')");

        // Сторінка лише для MANAGER
        http.authorizeRequests().antMatchers("/admin/product").access("hasRole('ROLE_MANAGER')");

        // Коли логін, role XX.
        // Але для доступу до сторінки потрібна роль YY,
        // AccessDeniedException.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        // Конфігурація тдля форми Логін
        http.authorizeRequests().and().formLogin()//

                //
                .loginProcessingUrl("/j_spring_security_check") // Надіслати URL
                .loginPage("/admin/login")//
                .defaultSuccessUrl("/admin/accountInfo")//
                .failureUrl("/admin/login?error=true")//
                .usernameParameter("userName")//
                .passwordParameter("password")

                // Конфігурація для сторінки виходу.
                // (Після виходу перехід на головну сторінку)
                .and().logout().logoutUrl("/admin/logout").logoutSuccessUrl("/");

    }
}