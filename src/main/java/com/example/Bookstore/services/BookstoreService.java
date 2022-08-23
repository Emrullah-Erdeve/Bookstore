package com.example.Bookstore.services;

import com.example.Bookstore.dto.BookDto;
import com.example.Bookstore.entities.Book;
import com.example.Bookstore.repository.BookRepository;
import com.example.Bookstore.repository.BookStoreRepository;
import com.example.Bookstore.dto.BookStoreDto;
import com.example.Bookstore.entities.BookStore;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookstoreService {
    private final BookRepository bookRepository;
    private final BookStoreRepository bookStoreRepository;
    private final ModelMapper modelMapper;

    public BookstoreService(BookRepository bookRepository, BookStoreRepository bookStoreRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.bookStoreRepository = bookStoreRepository;
        this.modelMapper = modelMapper;
    }

    public BookStoreDto saveBookStore(BookStoreDto bookStoredto) {
        BookStore bookStore = modelMapper.map(bookStoredto, BookStore.class);

        return modelMapper.map(bookStoreRepository.save(bookStore), BookStoreDto.class);

    }

    public BookStoreDto findByid(Long id) {

        Optional<BookStore> bookStore = bookStoreRepository.findById(id);
        if (bookStore.isPresent()) {
            return modelMapper.map(bookStore.get(), BookStoreDto.class);
        }
        throw new RuntimeException("book id not found");
    }
//if ekle
    public BookStoreDto updateById(Long id, BookStoreDto bookStore) {
        BookStoreDto currentBookStore = this.findByid(id);
        currentBookStore.setBookStoreName(bookStore.getBookStoreName());
        currentBookStore.setCity(bookStore.getCity());
        currentBookStore.setBookstorebook(bookStore.getBookstorebook());
        return modelMapper.map(bookStoreRepository.save(modelMapper.map(currentBookStore, BookStore.class)), BookStoreDto.class);
    }


    public List<BookStoreDto> getAllBookstore() {
        List<BookStore> bookStores = bookStoreRepository.findAll();
       return bookStores.stream().map(bookstore -> modelMapper.map(bookstore, BookStoreDto.class)).collect(Collectors.toList());
    }


    public BookStoreDto bookstoredelete(Long bookStoreId, Long bookId) {
        Optional <Book> book =bookRepository.findById((bookId));
        Optional <BookStore> bookStore =bookStoreRepository.findById(bookStoreId);
        bookStore.get().getBookstorebook().remove(book.get());
        return updateById(bookStoreId,modelMapper.map(bookStore.get(),BookStoreDto.class));
    }
}
