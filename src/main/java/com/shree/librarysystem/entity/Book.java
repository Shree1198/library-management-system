package com.shree.librarysystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private boolean borrowed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User borrowedBy;

    private int copiesAvailable;
}
