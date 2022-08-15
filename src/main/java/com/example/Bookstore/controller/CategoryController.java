package com.example.Bookstore.controller;

import com.example.Bookstore.entities.Book;
import com.example.Bookstore.entities.Category;
import com.example.Bookstore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService category_service;

    @PostMapping("/add")
    public Optional<Category> saveCategory(@RequestBody Category category) {
        return Optional.ofNullable(category_service.saveCategory(category));
    }

    @GetMapping("/categoryget")
    public Optional<Category> getCategory(@RequestBody Category category){

        return category_service.findById(category.getCid());
    }

    @GetMapping ("/getbycategory/{id}")
    public List<Book> getByCategory(@PathVariable Integer id){

        return category_service.bookListByCategory(id);
    }


    @GetMapping("/getall")
    public List<Category> getallbook (){
        return category_service.getAllCategory();
    }

    @PostMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Integer id)
    {

        category_service.deleteCategory(id);
        return "successfully";

    }



}
