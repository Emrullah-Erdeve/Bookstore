package com.example.Bookstore.dto;

import com.example.Bookstore.entities.BookStore;
import com.example.Bookstore.entities.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.net.URL;
import java.util.Set;

@Data
@EqualsAndHashCode
public class BookDto {
    private Long id;
    private String bookName;
    private String Author;
    //author küçük olucak.
    private URL image;
    private String description;
    private Long price;

    @JsonIgnoreProperties({"books"})
    private Category category;

    @JsonIgnoreProperties({"bookStoreBooks","id"})
    private Set<BookStore> bookstores;
}
