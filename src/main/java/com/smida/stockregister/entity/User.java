package com.smida.stockregister.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(length = 512, name = "password")
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Role> roles;

    public User(String username, String password, String name, String surname, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        roles = new ArrayList();
    }

    public List<String> getRolesString() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < roles.size(); i++) {
            list.add(roles.get(i).getRoleName());
        }
        return list;
    }
}
