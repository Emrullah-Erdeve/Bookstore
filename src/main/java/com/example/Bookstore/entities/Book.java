package com.example.Bookstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="book")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Book  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;
    private String Author;
    private String Description;
    private Long price;
    private URL image;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "bookstorebook")
    @JsonIgnoreProperties({"bookstorebook"})
    @ToString.Exclude
    private Set <BookStore> bookstores=new HashSet<>();



    @JsonIgnoreProperties({"books"})
    @ManyToOne
   @JoinColumn(name="category_id")
   private Category category;





}
