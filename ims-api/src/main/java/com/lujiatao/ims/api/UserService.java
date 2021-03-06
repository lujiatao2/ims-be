package com.lujiatao.ims.api;

import com.lujiatao.ims.common.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ims-service", path = "/user")
public interface UserService {

    @PostMapping
    boolean add(@RequestBody User user);

    @PutMapping
    boolean modify(@RequestBody User user);

    @DeleteMapping
    boolean deleteById(@RequestParam("id") int id);

    @GetMapping("/{id}")
    User getById(@PathVariable int id);

    @GetMapping("/search")
    List<User> search(@RequestParam("username") String username);

    @GetMapping
    List<User> getAll();

}
