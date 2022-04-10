package com.assignment.two.assignmenttwo;

import com.assignment.two.assignmenttwo.entity.Role;
import com.assignment.two.assignmenttwo.entity.User;
import com.assignment.two.assignmenttwo.repo.RoleRepository;
import com.assignment.two.assignmenttwo.repo.UserRepository;
import com.assignment.two.assignmenttwo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AssignmentTwoApplication {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(AssignmentTwoApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

//    @Override
//    public void run(String... args) throws Exception {
//
//        Role role1= new Role(1,"ROLE_ADMIN");
//        Role role2 = new Role(2,"ROLE_USER");
//
//        roleRepository.save(role1);
//        roleRepository.save(role2);
//
//        List<Role> roleList = new ArrayList<Role>();
//        roleList.add(role1);
//
//
//        User userData = new User(1,"Sandesh Lohani","admin",passwordEncoder.encode("admin"),"sandesh.lohani1991@gmail.com",roleList,null,null);
//        userRepository.save(userData);
//    }

}
