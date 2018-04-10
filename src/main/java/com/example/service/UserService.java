package com.example.service;

import com.example.domain.User;
import com.example.enums.ResultEnum;
import com.example.exception.UserException;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ge.Mao on 2018/4/11
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void insertTwo() {
        User userA = new User();
        userA.setName("a");
        userA.setAge(18);
        userRepository.save(userA);

        User userB = new User();
        userA.setName("b");
        userA.setAge(10);
        userRepository.save(userB);
    }

    public void getAge(Integer id) throws Exception {
        User user = userRepository.getOne(id);
        Integer age = user.getAge();
        if (age < 10) {
            throw new UserException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            throw new UserException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
}
