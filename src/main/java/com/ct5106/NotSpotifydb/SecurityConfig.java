package com.ct5106.NotSpotifydb;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//import org.springframework.beans.factory.annotation.Autowired;
//import service.UserDetailsServiceImpl;
import com.ct5106.NotSpotifydb.service.UserDetailsServiceImpl;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import static org.springframework.security.config.Customizer.withDefaults;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	private final UserDetailsServiceImpl userDetailsService;

   
    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

  
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Set the default UserDetailsService and password encoder
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
   
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
    	UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();
    	CorsConfiguration config= new CorsConfiguration();
    	config.setAllowedOrigins(Arrays.asList("*"));
    	config.setAllowedMethods(Arrays.asList("*"));
    	config.setAllowedHeaders(Arrays.asList("*"));
    	config.setAllowCredentials(false);
    	config.applyPermitDefaultValues();
    	source.registerCorsConfiguration("/**", config);
        return source;    	
    }
    
    @Bean 
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    	http.csrf((csrf)->
    	csrf.disable()).cors(withDefaults()).authorizeHttpRequests((authorizeHttpRequests)->authorizeHttpRequests.anyRequest().permitAll());
    	return http.build();
    }
}


