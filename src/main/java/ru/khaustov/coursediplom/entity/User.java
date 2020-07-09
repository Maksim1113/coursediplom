package ru.khaustov.coursediplom.entity;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
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
    //@NotEmpty(message = "*Пожалуйста введите ваш ник")
    private String userName;

    @Column(name = "name")
    //@NotEmpty(message = "*Пожалуйста введите ваше имя")
    private String name;

    @Column(name = "last_name")
    //@NotEmpty(message = "*Пожалуйста введите вашу фамилию")
    private String lastName;

    /*@Column(name = "fonNumber")
    @Length(min = 12, message = "*Ваш номер телефона должен быть записан ввиде 8хххххххххх")
    //@NotEmpty(message = "*Пожалуйста введите ваш номер телефона")
    private String fonNumber;*/

    @Column(name = "email")
    //@Email(message = "*Пожалуйста введите действующий Email")
    //@NotEmpty(message = "*Пожалуйста введите ваш email")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "*Ваш пароль должен быть длиннее 5 символов")
    //@NotEmpty(message = "*Пожалуйста введите пароль")
    private String password;

    @Column(name = "active")
    private boolean active;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
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

    public void setSurname(String lastName) {
        this.lastName = lastName;
    }

/*    public String getFonNumber() {
        return fonNumber;
    }

    public void setFonNumber(String fonNumber) {
        this.fonNumber = fonNumber;
    }*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String eMail) {
        this.email = email;
    }
}


