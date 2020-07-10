package ru.khaustov.coursediplom.entity;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;

    @Column(name = "user_name")
    @Length(min = 10, message = "*Ваш ник должен быть не менее 10 символов")
    private String userName;

    @Column(name = "name")
    @Length(min = 2, message = "*Ваше имя должно быть не менее 2 символов")
    private String name;

    @Column(name = "last_name")
    @Length(min = 3, message = "*Ваша фамилия должна быть не менее 3 символов")
    private String lastName;


    @Column(name = "email")
    @Email(message = "*Пожалуйста введите действующий Email")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "*Ваш пароль должен быть длиннее 5 символов")
    private String password;

    @Column(name = "active")
    private boolean active;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lasTName) {
        this.lastName = lasTName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String eMail) {
        this.email = eMail;
    }
}


