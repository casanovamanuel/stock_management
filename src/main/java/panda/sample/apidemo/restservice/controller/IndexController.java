package panda.sample.apidemo.restservice.controller;

import java.util.List;
import java.util.Objects;

//import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.http.ZeroCopyHttpOutputMessage;

import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.servlet.http.HttpSession;
import panda.sample.apidemo.restservice.repository.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import panda.sample.apidemo.restservice.model.User;

@RestController
@RequestMapping("/")
public class IndexController {
    private static class InputUser {
        private String username;
        private String password;

        public InputUser() {
        }

        public InputUser(String name, String pass) {
            this.username = name;
            this.password = pass;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

    }

    @Autowired
    UserRepository repo;

    @GetMapping("/")
    public String index() {
        return "Hola";
    }

    @PostMapping("/login")
    public String login(@RequestBody InputUser entity) {
        User user = repo.findByUsername(entity.username);

        if (Objects.isNull(user))
            return "not found";
        if (!user.validate(entity.password))
            return "nop";
        String token = "token";
        return token;
    }

    @GetMapping("/secured")
    public String secured(@RequestHeader("token") String token) {
        if (Objects.isNull(token)) {
            return "not found";
        }
        return "Secured";
    }

}
