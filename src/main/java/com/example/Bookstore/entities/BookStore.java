package com.example.Bookstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BookStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookStoreName;
    private String City;
    private Long zamOranı;

    @JsonIgnoreProperties({"bookstores"})
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "bookstore_book",
            joinColumns = {@JoinColumn(name = "bookstore_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    @ToString.Exclude
    private Set<Book> bookstorebook = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BookStore bookStore = (BookStore) o;
        return id != null && Objects.equals(id, bookStore.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
