package com.Jwt.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import java.util.ArrayList;
import java.util.List;
@Configuration
public class AppConfig
{

     /*
     Purpose: The @Bean annotation tells Spring that the
     method annotated with it will return an object that should be registered as a bean in the Spring
     container.
     * */
     @Bean
     public UserDetailsService userDetailsService()//
     {
          UserDetails user=User.builder().username("mohit").password(passwordEncoder().encode("admin")).roles("admin").build();
          UserDetails user1=User.builder().username("yash").password(passwordEncoder().encode("user")).roles("admin").build();

          //just for  exploring
//                         List<UserDetails> userList=new ArrayList<>();
//                         userList.add(user);
//                         userList.add(user1);
//                         return  new InMemoryUserDetailsManager(userList);
          //end

          return new  InMemoryUserDetailsManager(user,user1);

     }
     @Bean
     public PasswordEncoder passwordEncoder()
     {
          return new BCryptPasswordEncoder();
     }


}
