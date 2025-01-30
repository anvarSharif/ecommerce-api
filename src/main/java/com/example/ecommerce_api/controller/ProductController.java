package com.example.ecommerce_api.controller;

import com.example.ecommerce_api.dto.ProductSaveDTO;
import com.example.ecommerce_api.entity.Product;
import com.example.ecommerce_api.repo.AttachmentRepository;
import com.example.ecommerce_api.repo.CategoryRepository;
import com.example.ecommerce_api.repo.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final AttachmentRepository attachmentRepository;

    public ProductController(ProductRepository productRepository,
                             CategoryRepository categoryRepository,
                             AttachmentRepository attachmentRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.attachmentRepository = attachmentRepository;
    }

    @GetMapping
    public List<Product> getProducts(@RequestParam(required = false) Integer categoryId){
       if (categoryId!=null){
           return productRepository.findAllByCategoryId(categoryId);
       }else {
           return productRepository.findAll();
       }
    }
    @GetMapping("{id}")
    public Product getOneProducts(@PathVariable Integer id){
           return productRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void saveProduct(@RequestBody ProductSaveDTO productSaveDTO){
        Product product = Product.builder()
                .name(productSaveDTO.getName())
                .price(productSaveDTO.getPrice())
                .category(categoryRepository.findById(productSaveDTO.getCategoryId()).orElseThrow())
                .photo(attachmentRepository.findById(productSaveDTO.getAttachmentId()).orElseThrow())
                .build();
        productRepository.save(product);
    }
    @PutMapping("{id}")
    public void editeProduct(@PathVariable Integer id,@RequestBody ProductSaveDTO productSaveDTO){
        Product product = Product.builder()
                .id(id)
                .name(productSaveDTO.getName())
                .price(productSaveDTO.getPrice())
                .category(categoryRepository.findById(productSaveDTO.getCategoryId()).orElseThrow())
                .photo(attachmentRepository.findById(productSaveDTO.getAttachmentId()).orElseThrow())
                .build();
        productRepository.save(product);
    }



    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productRepository.deleteById(id);
    }
}
