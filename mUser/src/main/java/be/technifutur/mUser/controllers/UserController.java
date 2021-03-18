package be.technifutur.mUser.controllers;

import be.technifutur.mUser.dtos.UserDto;
import be.technifutur.mUser.entities.User;
import be.technifutur.mUser.services.UserService;
import be.technifutur.mUser.utils.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable int id) throws UserNotFoundException {
        return this.userService.getUserById(id);
    }

    @PostMapping
    public void insertUser(@RequestBody User user) {
        this.userService.insertUser(user);
    }

    @PostMapping("/check")
    public ResponseEntity<UserDto> getUserByPseudoAndPassword(@RequestBody Map<String, String> values) throws UserNotFoundException {
        return ResponseEntity.ok(
                this.userService.getUserByPseudoAndPassword(
                        values.get("pseudo"), values.get("password")
                )
        );
    }
}
