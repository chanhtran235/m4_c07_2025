package org.example.demo_spring_mvc.config;

import org.example.demo_spring_mvc.repository.StudentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigApp {
    @Bean
    public StudentRepository studentRepository(){
        return new StudentRepository();
    }
}
