package com.frontbackend.springboot.users;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<String> findUsernames(@RequestParam(value = "filter", required = false) String filter) {
        return userService.findUsernames(filter);
    }

    @GetMapping("/top")
    public List<String> getTopUsernames() {
        return userService.getTopUsernames();
    }

    @PostMapping("/top")
    public void top(@RequestBody SaveTopUsersRequest request) {
        userService.saveTopUsers(request.getUsernames());
    }
}
