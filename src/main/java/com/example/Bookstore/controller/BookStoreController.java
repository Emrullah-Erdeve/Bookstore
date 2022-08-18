package com.example.Bookstore.controller;


import com.example.Bookstore.dto.BookDto;
import com.example.Bookstore.dto.BookStoreDto;
import com.example.Bookstore.dto.CategoryDto;
import com.example.Bookstore.entities.Book;
import com.example.Bookstore.entities.BookStore;

import com.example.Bookstore.services.BooksService;
import com.example.Bookstore.services.BookstoreService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/bookstore")
public class BookStoreController {

    private final BookstoreService bookstore_service;
    private final ModelMapper modelMapper;


    public BookStoreController(BookstoreService bookstore_service, ModelMapper modelMapper, BooksService booksService) {
        this.bookstore_service = bookstore_service;
        this.modelMapper = modelMapper;
        this.booksService = booksService;
    }

    private final BooksService booksService;


    @PostMapping("/add")
    public BookStoreDto saveBookstore(@RequestBody BookStoreDto bookStoreDto) {
        bookStoreDto = modelMapper.map(bookStoreDto, BookStoreDto.class);
        return bookstore_service.saveBookStore(bookStoreDto);
    }

    @GetMapping("/getbook/{id}")
    public BookStoreDto BookStorefindBookInRepository(@PathVariable Long id) {
        return bookstore_service.findByid(id);
    }

    @PutMapping("/put/{bookStoreId}/books/{bookId}")
    public BookStoreDto bookToBookStore(@PathVariable Long bookStoreId, @PathVariable Long bookId) {
        BookStoreDto bookStore = bookstore_service.findByid(bookStoreId);
        BookDto book = booksService.findByid(bookId);
        bookStore.getBookstorebook().add(modelMapper.map(book, Book.class));
        book.getBookstores().add(modelMapper.map(bookStore, BookStore.class));
        booksService.updateById(bookId, book);
        return bookstore_service.updateById(bookStoreId, bookStore);
    }

    @GetMapping("/getall")
    public List<BookStoreDto> getallbook() {
        return bookstore_service.getAllBookstore();
    }


}
