package com.ykh.project.tutorial.controler;


import com.ykh.project.tutorial.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/{userId}")
public class ExamplePathVaribaleController {

    @GetMapping(value = "/current")
    public String showMe(@PathVariable Long userId) {
        return "Current User :" + userId;
    }

    @PostMapping(path = "/post")
    public User testPost(@RequestBody User
                                 user) {

        return user;
    }
}
