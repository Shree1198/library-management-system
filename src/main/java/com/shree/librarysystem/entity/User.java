package com.shree.librarysystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    @OneToMany(mappedBy = "borrowedBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> borrowedBooks;
}