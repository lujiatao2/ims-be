package com.lujiatao.ims.service.impl;

import com.lujiatao.ims.common.entity.User;
import com.lujiatao.ims.service.repository.UserDAO;
import com.lujiatao.ims.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @PostMapping
    public boolean add(User user) {
        return userDAO.insert(user);
    }

    @Override
    @PutMapping
    public boolean modify(User user) {
        return userDAO.update(user);
    }

    @Override
    @DeleteMapping
    public boolean deleteById(int id) {
        return userDAO.deleteById(id);
    }

    @Override
    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return userDAO.selectById(id);
    }

    @Override
    @GetMapping("/search")
    public List<User> search(@RequestParam("username") String username) {
        return userDAO.selectByUsername(username);
    }

    @Override
    @GetMapping
    public List<User> getAll() {
        return userDAO.selectAll();
    }

}
