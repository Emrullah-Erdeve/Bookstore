package com.example.Bookstore.dto;


import com.example.Bookstore.entities.Book;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode
public class CategoryDto {
    private Integer cid;
    private String categoryName;
    private String descate;
    @JsonIgnoreProperties({"category"})
    private Set<Book> books;
}
