package com.example.controller;

import com.example.domain.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Ge.Mao on 2018/4/7
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有用户列表
     *
     * @return the list
     */
    @GetMapping("/users")
    public List<User> userList() {
        return userRepository.findAll();
    }

    /**
     * 新增一个用户
     * @param user
     * @return
     */
    @PostMapping("/users")
    public User userAdd(User user) {
        return userRepository.save(user);
    }

    /**
     * 根据id查询一个用户
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") Integer id) {
        return userRepository.findById(id);
    }

    /**
     * 搜索用户
     * @param user
     * @return
     */
    @PostMapping("/users/search")
    public List<User> userSearch(User user) {
        Example<User> example = Example.of(user);
        return userRepository.findAll(example);
    }

    /**
     * 修改用户信息
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/users/{id}")
    public User userUpdate(@PathVariable Integer id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @DeleteMapping("/users/{id}")
    public void userDelete(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }
}
