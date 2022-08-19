package com.example.Bookstore.services;

import com.example.Bookstore.repository.BookStoreRepository;
import com.example.Bookstore.dto.BookStoreDto;
import com.example.Bookstore.entities.BookStore;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookstoreService {

    private final BookStoreRepository bookStoreRepository;
    private final ModelMapper modelMapper;

    public BookstoreService(BookStoreRepository bookStoreRepository, ModelMapper modelMapper) {
        this.bookStoreRepository = bookStoreRepository;
        this.modelMapper = modelMapper;
    }

    public BookStoreDto saveBookStore(BookStoreDto bookStoredto) {
        BookStore bookStore1 = modelMapper.map(bookStoredto, BookStore.class);

        return modelMapper.map(bookStoreRepository.save(bookStore1), BookStoreDto.class);

    }

    public BookStoreDto findByid(Long id) {

        Optional<BookStore> bookStore = bookStoreRepository.findById(id);
        if (bookStore.isPresent()) {
            return modelMapper.map(bookStore.get(), BookStoreDto.class);
        }
        return null;


    }

    public BookStoreDto updateById(Long id, BookStoreDto bookStore) {
        BookStoreDto currentBookStore = this.findByid(id);
        currentBookStore.setBookStoreName(bookStore.getBookStoreName());
        currentBookStore.setCity(bookStore.getCity());
        currentBookStore.setBookstorebook(bookStore.getBookstorebook());
        return modelMapper.map(bookStoreRepository.save(modelMapper.map(currentBookStore, BookStore.class)), BookStoreDto.class);
    }


    public List<BookStoreDto> getAllBookstore() {
        List<BookStore> bookStores = bookStoreRepository.findAll();
        List<BookStoreDto> bookStores1 = bookStores.stream().map(bookstore -> modelMapper.map(bookstore, BookStoreDto.class)).collect(Collectors.toList());
        return bookStores1;
    }
}
