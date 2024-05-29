package com.example.ogani.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.example.ogani.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.ogani.entity.Category;
import com.example.ogani.exception.NotFoundException;
import com.example.ogani.model.request.CreateCategoryRequest;
import com.example.ogani.repository.CategoryRepository;
import com.example.ogani.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;


    public List<Object[]> getProductCountByCategory() {
        return categoryRepository.getProductCountByCategory();
    }

    @Override
    public List<Category> findAll() {
        // TODO Auto-generated method stub
        List<Category> list = categoryRepository.findAll(Sort.by("id").descending());
        return list;
    }

    @Override
    public Category createCategory(CreateCategoryRequest request) {

        // TODO Auto-generated method stub
        Category category = new Category();
        category.setName(request.getName());
        category.setQuantity(request.getQuantity());
        category.setDate(LocalDateTime.now());
        category.setEnable(false);
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category updateCategory(long id, CreateCategoryRequest request) {
        // TODO Auto-generated method stub
        Category category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Category With Id: " + id));
        category.setName(request.getName());
        category.setQuantity(request.getQuantity());
        category.setDate(LocalDateTime.now());
        categoryRepository.save(category);
        return category;
    }

    @Override
    public void enableCategory(long id) {
        // TODO Auto-generated method stub
        Category category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Category With Id: " + id));
        if(category.isEnable()){
            category.setEnable(false);
        } else{
            category.setEnable(true);
        }
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(long id) {
        // TODO Auto-generated method stub
        Category category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Category With Id: " + id));
        categoryRepository.delete(category);
    }

    @Override
    public List<Category> getListEnabled() {
        // TODO Auto-generated method stub
        List<Category> list = categoryRepository.findALLByEnabled();
        return list;
    }

}
