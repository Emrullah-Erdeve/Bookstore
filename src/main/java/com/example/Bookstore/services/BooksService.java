package com.example.Bookstore.services;

import com.example.Bookstore.dto.BookDto;
import com.example.Bookstore.entities.Book;
import com.example.Bookstore.repository.BookRepository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class BooksService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BooksService(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    public BookDto addBook(BookDto bookDto) {
        Book book = modelMapper.map(bookDto, Book.class);

        return modelMapper.map(bookRepository.save(book), BookDto.class);
    }

    public BookDto findByid(Long id) {

        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return modelMapper.map(book.get(), BookDto.class);
        }
        return null;

    }

    public List<BookDto> getAllBook() {
        List<Book> books = bookRepository.findAll();
       return books.stream().map(book -> modelMapper.map(book, BookDto.class)).collect(Collectors.toList());

    }
//void yapılmalı new yaz
    public BookDto  updateById(Long id, BookDto book) {
        BookDto yeniBook = this.findByid(id);
        yeniBook.setBookName(book.getBookName());
        yeniBook.setAuthor(book.getAuthor());
        yeniBook.setDescription(book.getDescription());
        yeniBook.setImage(book.getImage());
        yeniBook.setCategory(book.getCategory());
        yeniBook.setBookstores(book.getBookstores());
        return modelMapper.map(bookRepository.save(modelMapper.map(yeniBook, Book.class)), BookDto.class);
    }

    public void deleteBook(Long id) {

        BookDto yeniBook = this.findByid(id);
        bookRepository.delete(modelMapper.map(yeniBook, Book.class));

    }

}

