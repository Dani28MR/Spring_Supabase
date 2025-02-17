package com.tarea.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Entity
@Table(name = "Tarea")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "estatus")
    private Boolean estatus;
    @Column(name = "date")
    private LocalDate date;

    public Tarea() {

    }

    public Tarea(Long id, String name, String description, LocalDate date, Boolean estatus) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.estatus = estatus;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getEstatus() {
        return this.estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", estatus=" + estatus +
                '}';
    }
}
