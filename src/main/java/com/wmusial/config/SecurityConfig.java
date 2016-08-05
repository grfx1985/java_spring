package com.wmusial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

// konfiguracja zabezpieczenia aplikacji logowanie itd
@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // ctrl + o i wybieramy configura....

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN"); // developement login option

        // auth.jdbcAuthentication().dataSource(dataSource); // uzywanie jdbc standard java  pobiera autowire z hibernate config.
        // spring zaklada ze mamy users table z username  i password kolumnami
    }
}
