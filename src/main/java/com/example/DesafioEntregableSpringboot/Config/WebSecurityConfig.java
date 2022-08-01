package com.example.DesafioEntregableSpringboot.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/api/Laptops/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin()
                .and().httpBasic();

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web)-> web.ignoring().antMatchers("/images/**","/js/**", "/webjars/**");
    }
    @Bean
    public InMemoryUserDetailsManager configureAuthentication(){
        List<UserDetails> details= new ArrayList<>();
        List<GrantedAuthority> userRole= new ArrayList<>();
        List<GrantedAuthority> adminRole= new ArrayList<>();
        userRole.add(new SimpleGrantedAuthority("USER"));
        adminRole.add(new SimpleGrantedAuthority("ADMIN"));
        String psw1= BCrypt.hashpw("Rutito2010",BCrypt.gensalt(10));
        String psw2= BCrypt.hashpw("Julieta2010",BCrypt.gensalt(10));

        details.add( new User("user", psw1 ,userRole));
        details.add( new User("admin",psw2,adminRole));


        return  new InMemoryUserDetailsManager(details);
    }

}
