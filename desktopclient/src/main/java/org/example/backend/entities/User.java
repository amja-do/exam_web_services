package org.example.backend.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;

    @OneToMany(mappedBy = "bookedBy")
    private Set<CD> bookedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<CD> getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(Set<CD> bookedBy) {
        this.bookedBy = bookedBy;
    }

    public User(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public User() {
    }
}
