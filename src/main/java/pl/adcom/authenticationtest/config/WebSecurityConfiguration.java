package pl.adcom.authenticationtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder EncodePass(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User admin = new User("Adrian", EncodePass().encode("adek123"), Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));
        User user = new User("Jan", EncodePass().encode("jan123"), Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
        User testUser = new User("test", EncodePass().encode("test"), Collections.singleton(new SimpleGrantedAuthority("ROLE_TEST")));

        auth.inMemoryAuthentication().withUser(admin);
        auth.inMemoryAuthentication().withUser(user);
        auth.inMemoryAuthentication().withUser(testUser);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        String[] pathArray = new String[]{"/user", "/forAll"};

        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER", "ADMIN")
                .antMatchers("/forAll").permitAll()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().logoutSuccessUrl("/papa");
    }
}
