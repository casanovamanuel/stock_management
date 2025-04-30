package panda.sample.apidemo.restservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsernme() {
        return username;
    }

    public Boolean validate(String inputPassword) {
        System.out.println(password);
        System.out.println(inputPassword);
        return (inputPassword.equals(this.password));
    }

}
