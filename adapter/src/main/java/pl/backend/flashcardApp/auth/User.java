package pl.backend.flashcardApp.auth;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@NoArgsConstructor
@Entity
@Table(name = "users")
class User {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String name;
    private String username;
    private String password;

    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

    User(final Long id, final String name, final String username, final String password, final Collection<Role> roles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    Long getId() {
        return id;
    }

    void setId(final Long id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    String getUsername() {
        return username;
    }

    void setUsername(final String username) {
        this.username = username;
    }

    String getPassword() {
        return password;
    }

    void setPassword(final String password) {
        this.password = password;
    }

    Collection<Role> getRoles() {
        return roles;
    }

    void setRoles(final Collection<Role> roles) {
        this.roles = roles;
    }
}

