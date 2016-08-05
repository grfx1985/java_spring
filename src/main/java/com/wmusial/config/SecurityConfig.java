package com.wmusial.config;

import com.wmusial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

// konfiguracja zabezpieczenia aplikacji logowanie itd
@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // ctrl + o i wybieramy configura....



//      uzywane z opcja jdbc to co nizej
//    @Autowired
//    private DataSource dataSource;


    @Autowired
    private UserService userService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN"); // developement login option

        // auth.jdbcAuthentication().dataSource(dataSource); // uzywanie jdbc standard java  pobiera autowire z hibernate config.
        // spring zaklada ze mamy users table z username  i password kolumnami

        auth.userDetailsService(userService); // opcja z frameworkiem spring hibernate 3 opcja
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception { // dopasowanie odpowiednich widokow nie default springowy ekran logowania/ rejestracji itd.
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/**").authenticated()


                .and()


                .formLogin()
                    .usernameParameter("emial")
                    .passwordParameter("password")
                    .loginPage("/login")
                    .loginProcessingUrl("/login") // gdzie leci post


                .and()


                .csrf()
                    .disable() // przyklad w formularzu bedzie  pozniej jak przygotowac zeby dzialalo

                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout");

    }
}

