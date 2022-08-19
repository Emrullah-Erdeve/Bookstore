package com.example.Bookstore.controller;

import com.example.Bookstore.dto.BookDto;
import com.example.Bookstore.dto.CategoryDto;

import com.example.Bookstore.entities.Category;
import com.example.Bookstore.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService category_service;
    private final ModelMapper modelMapper;

    public CategoryController(CategoryService category_service, ModelMapper modelMapper) {
        this.category_service = category_service;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add")
    public Optional<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto) {
        categoryDto = modelMapper.map(categoryDto, CategoryDto.class);
        return Optional.ofNullable(category_service.saveCategory(categoryDto));
    }

    @GetMapping("/categoryget")
    public CategoryDto getCategory(@RequestBody CategoryDto categoryDto) {
        modelMapper.map(categoryDto.getCid(), Category.class);
        return category_service.findById(categoryDto.getCid());
    }

    @GetMapping("/getbycategory/{id}")
    public List<BookDto> getByCategory(@PathVariable Integer id) {
        return category_service.bookListByCategory(id);
    }


    @GetMapping("/getall")
    public List<CategoryDto> getallbook() {
        return category_service.getAllCategory();
    }


}
