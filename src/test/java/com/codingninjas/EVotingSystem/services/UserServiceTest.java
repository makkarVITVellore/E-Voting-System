package com.codingninjas.EVotingSystem.services;

import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    UserService userService;

    /*Its not recommended @BeforeAll because for each test method, a new instance of the test class is created.
    * @BeforeAll runs before these instances are created. If its non-static, it will require an instance
    * of the class. Hence we will have to make the @BeforeAll method static. But in this case we won't be
    * able to access userRepository since it is a non-static variable.  */
    @BeforeEach
    public void setup(){
        userService = new UserService(userRepository);
    }

    @Test
    public void testCreateUser(){

        //create and mock the dependencies
        User user = new User(1,"Shivesh");

        Mockito.when(userRepository.save(user)).thenReturn(user);

        //method call
        User createdUser = userService.createUser(user);

        Assertions.assertEquals(user, createdUser);
    }

    @Test
    public void testGetUsers(){

        List<User> userList = Arrays.asList(new User(1,"Kush"),new User(2,"Ram"),
                new User(30,"Keshav"));

        Mockito.when(userRepository.findAll()).thenReturn(userList);

        List<User> resultList = userService.getUsers();

        Assertions.assertEquals(userList,resultList);
    }
}
