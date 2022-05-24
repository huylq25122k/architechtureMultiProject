package com.example.app;

import UserService.IUserDAO;
import UserService.Service;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import userDAO.IUserDAOImpl;
import userDAO.h.UserRepository;

@Configuration
@ComponentScan({"userDAO.h", "userController"})
@EnableJpaRepositories("userDAO.h")
@EntityScan("userDAO.h")
public class SomeThing {

    @Bean
    public Service service(IUserDAO userDAO){
        return new Service(userDAO);
    }

    @Bean
    public IUserDAO dao(UserRepository userRepository){
        return new IUserDAOImpl (userRepository);
    }
}