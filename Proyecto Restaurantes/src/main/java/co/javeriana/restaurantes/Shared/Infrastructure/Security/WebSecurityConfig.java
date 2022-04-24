package co.javeriana.restaurantes.Shared.Infrastructure.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
//TODO Actualizar autenticacion y seguridad
//@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] AUTH_WHITELIST = {
            "/v3/api-docs/**",
            "/v3/api-docs.yaml",
            "/swagger-ui/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                //.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/empleado/all").permitAll()
                .antMatchers(HttpMethod.GET, "/insumo/all").permitAll()
                .antMatchers(HttpMethod.GET, "/insumo/id").permitAll()
                .antMatchers(HttpMethod.GET, "/plato/all").permitAll()
                .antMatchers(HttpMethod.GET, AUTH_WHITELIST).permitAll();
                //.anyRequest().authenticated();
    }

}
