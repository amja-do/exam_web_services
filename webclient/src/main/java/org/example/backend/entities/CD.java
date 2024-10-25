package org.example.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cds")
public class CD {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "booked_by")
    @ManyToOne
    @JoinColumn(name = "booked_by")
    private User bookedBy;

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

    public User getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(User bookedBy) {
        this.bookedBy = bookedBy;
    }

    public CD() {
    }
}
