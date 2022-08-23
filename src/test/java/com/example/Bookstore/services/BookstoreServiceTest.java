package com.example.Bookstore.services;

import com.example.Bookstore.entities.BookStore;
import com.example.Bookstore.repository.BookRepository;
import com.example.Bookstore.repository.BookStoreRepository;
import com.example.Bookstore.dto.BookStoreDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;


class BookstoreServiceTest {
    private BookstoreService bookstoreService;
    private ModelMapper modelMapper;
    private BookStoreRepository bookStoreRepository;
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {

        bookStoreRepository = Mockito.mock(BookStoreRepository.class);
        modelMapper = Mockito.mock(ModelMapper.class);
       bookRepository=Mockito.mock(BookRepository.class);
        bookstoreService = new BookstoreService(bookRepository, bookStoreRepository, modelMapper);
    }

    @Test
    public void whenSaveBookStoreReturnShouldBookStore() {
        BookStoreDto bookStoreDto = new BookStoreDto();
        bookStoreDto.setBookStoreName("kitapkurdu");
        bookStoreDto.setCity("ankara");
        bookStoreDto.setZamOranı((long) 12.5);
        bookStoreDto.setBookstorebook(null);

        BookStore bookStore1 = new BookStore();

        Mockito.when(modelMapper.map(bookStoreDto, BookStore.class)).thenReturn(bookStore1);
        Mockito.when(bookStoreRepository.save(bookStore1)).thenReturn(bookStore1);
        Mockito.when(modelMapper.map(bookStore1, BookStoreDto.class)).thenReturn(bookStoreDto);

        BookStoreDto result = bookstoreService.saveBookStore(bookStoreDto);

        assertEquals(result, bookStoreDto);
    }
}