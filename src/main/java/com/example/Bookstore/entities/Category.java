package com.example.Bookstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    private String categoryName;
    private String descate;

    @JsonIgnoreProperties("category")
    @OneToMany(mappedBy="category")
    private Set<Book> books = new HashSet<>();

}
