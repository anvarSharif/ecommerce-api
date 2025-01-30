package com.example.ecommerce_api.controller;

import com.example.ecommerce_api.dto.CategorySaveDTO;
import com.example.ecommerce_api.dto.ProductSaveDTO;
import com.example.ecommerce_api.entity.Category;
import com.example.ecommerce_api.entity.Product;
import com.example.ecommerce_api.repo.CategoryRepository;
import com.example.ecommerce_api.repo.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @GetMapping
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }
    @GetMapping("{id}")
    public Category getOneCategory(@PathVariable Integer id){
        return categoryRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void saveCategory(@RequestBody CategorySaveDTO categorySaveDTO){
        Category category = Category.builder()
                .name(categorySaveDTO.getName())
                .build();
        categoryRepository.save(category);
    }
    @PutMapping("{id}")
    public void editeCategory(@PathVariable Integer id,@RequestBody CategorySaveDTO categorySaveDTO){
        Category category = Category.builder()
                .id(id)
                .name(categorySaveDTO.getName())
                .build();
        categoryRepository.save(category);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id){
        categoryRepository.deleteById(id);
    }
}
