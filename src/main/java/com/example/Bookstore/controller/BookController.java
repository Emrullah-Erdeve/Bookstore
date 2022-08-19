package com.example.Bookstore.controller;

import com.example.Bookstore.dto.BookDto;

import com.example.Bookstore.services.BooksService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {


    private final BooksService books_service;
    private final ModelMapper modelMapper;

    public BookController(BooksService books_service, ModelMapper modelMapper) {
        this.books_service = books_service;
        this.modelMapper = modelMapper;
    }


    @PostMapping("/add")
    public BookDto saveBook(@RequestBody BookDto bookdto) {
        bookdto = modelMapper.map(bookdto, BookDto.class);
        return books_service.addBook(bookdto);

    }

    @GetMapping("/netbook/{id}")
    public BookDto getBook(@PathVariable Long id) {

        return books_service.findByid(id);
    }

    @GetMapping("/getall")
    public List<BookDto> getallbook() {
        return books_service.getAllBook();
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {

        books_service.deleteBook(id);
        return "successfully";

    }


}
