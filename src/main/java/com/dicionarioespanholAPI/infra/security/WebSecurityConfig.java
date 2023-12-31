package com.dicionarioespanholAPI.infra.security;

import com.dicionarioespanholAPI.infra.security.jwt.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.headers(headers -> headers.disable());
        http.cors(cors -> cors.disable()).csrf(csrf -> csrf.disable()).addFilterAfter(new JwtFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/swagger-ui/**","/v3/api-docs/**").permitAll()
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers("localhost:8080").permitAll()

//                        .requestMatchers("/dicionario/getImages/{id}").permitAll()
//                        .requestMatchers("/dicionario/listar-palavras").permitAll()
//                        .requestMatchers("/dicionario/buscar-palavra/{id}").permitAll()
//                        .requestMatchers("/dicionario/buscadepalavra/{nome}").permitAll()
//                        .requestMatchers("/dicionario/buscadepalavraNumLetra/{num}").permitAll()
//                        .requestMatchers("/dicionario/buscaPorLetraInicial/{letra}").permitAll()
//                        .requestMatchers("/dicionario/buscaPorLetraFinal/{letra}").permitAll()
//                        .requestMatchers("/dicionario/buscaPorCriterios").permitAll()
//                        .requestMatchers("/dicionario/adicionar").permitAll()
                        .requestMatchers("/dicionario/**").permitAll()

                        .requestMatchers("/administrador/**").permitAll()

                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}