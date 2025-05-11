package com.sistemasdistribuidos.epo2_v6.config;

import com.sistemasdistribuidos.epo2_v6.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuración de seguridad para la aplicación.
 * Define las reglas de acceso, autenticación, login, logout y seguridad CSRF.
 */
@Configuration
public class SecurityConfig {
    private final CustomUserDetailsService userDetailsService;

    /**
     * Constructor para inyectar el servicio de autenticación personalizado.
     *
     * @param userDetailsService servicio que proporciona detalles de usuario.
     */
    public SecurityConfig(CustomUserDetailsService userDetailsService) {

        this.userDetailsService = userDetailsService;
    }

    /**
     * Define la cadena de filtros de seguridad para el manejo de autenticación y autorización.
     *
     * @param http configuración HTTP de seguridad.
     * @return el filtro de seguridad configurado.
     * @throws Exception en caso de error al construir el filtro.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/register","/css/**", "/ws/**","/js/**","/images/**").permitAll()// Permitir acceso sin autenticación a login y register
                        .anyRequest().authenticated()  // Cualquier otra ruta requiere autenticación
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/ws/**") // Desactiva CSRF solo para WebSocket
                )
                .formLogin(form -> form
                        .loginPage("/login")  // Página de login personalizada
                        .defaultSuccessUrl("/home",true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll());  // Permitir logout sin autenticación

        return http.build();  // Construir el SecurityFilterChain
    }

    /**
     * Define el codificador de contraseñas utilizado en la aplicación.
     * Actualmente se usa NoOpPasswordEncoder para pruebas (sin cifrado).
     *
     * @return instancia de PasswordEncoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Solo para pruebas; luego deberías usar BCryptPasswordEncoder
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * Proporciona el AuthenticationManager necesario para la autenticación.
     *
     * @param config configuración de autenticación.
     * @return el gestor de autenticación configurado.
     * @throws Exception si ocurre un error al obtener el gestor.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
