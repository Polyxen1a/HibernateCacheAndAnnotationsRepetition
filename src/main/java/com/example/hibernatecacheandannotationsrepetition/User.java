package com.example.hibernatecacheandannotationsrepetition;


import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "time_of_modification")
    private Date timeOfModification;

    @Column(name = "roles")
    @ManyToMany(cascade = { CascadeType.ALL })
    private Set<Role> roles = new HashSet<>();
    private Object timeOfCreation;

    public User(String john, String doe) {
    }

    public User(int id, String name, String login) {
        this.id = id;
        this.name = name;
        this.login = login;
        roles = new HashSet<>(Arrays.asList(new Role("По умолчанию")));
        timeOfCreation = new Date();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Date getTimeOfModification() {
        return timeOfModification;
    }

    public void setTimeOfModification(Date timeOfModification) {
        this.timeOfModification = timeOfModification;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                name.equals(user.name) &&
                login.equals(user.login) &&
                password.equals(user.password) &&
                Objects.equals(timeOfCreation, user.timeOfCreation) &&
                Objects.equals(timeOfModification, user.timeOfModification) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, password, timeOfCreation, timeOfModification, roles);
    }

    public void setLastName(String smith) {
    }
}
