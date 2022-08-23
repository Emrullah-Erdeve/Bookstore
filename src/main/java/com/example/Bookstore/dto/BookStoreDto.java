package com.example.Bookstore.dto;


import com.example.Bookstore.entities.Book;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode
public class BookStoreDto {
    private Long id;
    private String bookStoreName;
    private String City;
    private Long zamOranı;

    @JsonIgnoreProperties({"bookstores"})
    private Set<Book> bookstorebook;
}
