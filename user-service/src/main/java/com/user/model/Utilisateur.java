package com.user.model;

import com.user.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Utilisateur extends User {

    public Utilisateur(Long id, String username, String email, String password, Role role) {
        super(id, username, email, password, role);
        this.setRole(Role.USER);
    }

    public Utilisateur() {
        this.setRole(Role.USER);
    }

}
