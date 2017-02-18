package com.training.repositories;

import com.training.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User tomas;
    private User santiago;

    @Before
    public void setUp() throws Exception {
        tomas = new User("tomas", "Estevarena", "t.estevarena@gmail.com", "1234");
        santiago = new User("santiago", "Romero", "s.romero@gmail.com", "1234");

        userRepository.save(tomas);
        userRepository.save(santiago);
    }

    @Test
    public void findAllUsersTest() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);

        assertTrue(users.size() == 2);
        assertTrue(users.contains(tomas));
        assertTrue(users.contains(santiago));
    }
}