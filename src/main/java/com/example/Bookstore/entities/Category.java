package com.example.Bookstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Category")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    private String categoryName;
    private String descate;

    @JsonIgnoreProperties("category")
    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    private Set<Book> books = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Category category = (Category) o;
        return cid != null && Objects.equals(cid, category.cid);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
