package com.example.criteriaapi.article;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "articles")
@Entity
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "duration", nullable = false)
    private int duration;
}
