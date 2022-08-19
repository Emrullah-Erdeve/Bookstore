package com.example.Bookstore.services;


import com.example.Bookstore.repository.BookRepository;
import com.example.Bookstore.repository.CategoryRepository;
import com.example.Bookstore.dto.BookDto;
import com.example.Bookstore.dto.CategoryDto;
import com.example.Bookstore.entities.Book;
import com.example.Bookstore.entities.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {


    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository, BookRepository bookRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    public CategoryDto findById(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return modelMapper.map(category.get(), CategoryDto.class);
        }
        return null;
    }


    public CategoryDto saveCategory(CategoryDto categorydto) {
        Category category = modelMapper.map(categorydto, Category.class);

        return modelMapper.map(categoryRepository.save(category), CategoryDto.class);

    }

    public List<BookDto> bookListByCategory(Integer id) {
        List<Book> book = bookRepository.findByCategory_Cid(id);
        List<BookDto> bookDtos = book.stream().map(book1 -> modelMapper.map(book1, BookDto.class)).collect(Collectors.toList());
        return bookDtos;

    }

    public List<CategoryDto> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos1 = categories.stream().map(category -> modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
        return categoryDtos1;
    }


}
