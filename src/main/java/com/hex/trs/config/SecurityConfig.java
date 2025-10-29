package com.hex.trs.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    // users legitimate --In memory Auth Users
    @Bean
    public UserDetailsService users() {
        UserDetails user1 = User.builder()
                .username("harry")
                .password("{noop}harry123")
                .roles("CUSTOMER")
                .build();
        UserDetails user2 = User.builder()
                .username("ronald")
                .password("{noop}ronald123")
                .roles("CUSTOMER")
                .build();
        UserDetails user3 = User.builder()
                .username("john")
                .password("{noop}john123")
                .roles("EXECUTIVE")
                .build();

        return new InMemoryUserDetailsManager(user1, user2,user3);
    }

    //SecurityFilterChain Bean
    @Bean
    public SecurityFilterChain securedFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.GET, "/api/auth/public/hello").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/auth/employee/hello").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/auth/customer/hello").hasAnyRole("CUSTOMER")
                       .requestMatchers(HttpMethod.GET, "/api/auth/executive/hello").hasAnyRole("EXECUTIVE")
                       .requestMatchers(HttpMethod.POST, "/api/customer/signup").permitAll()

                        .anyRequest().authenticated()
                );
        http.httpBasic(Customizer.withDefaults()); //register http basic aut with spring
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
