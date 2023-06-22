package com.personalAdministrative.BDSigipes.controller;

import com.personalAdministrative.BDSigipes.entities.CategoryModel;
import com.personalAdministrative.BDSigipes.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/addCategory")
    public ResponseEntity<CategoryModel> saveCategory(@RequestBody CategoryModel categoryModel){
        if(categoryModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        CategoryModel category = categoryRepository.save(categoryModel);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/findAllCategory")
    public List<CategoryModel> getAllCategory(){
        return categoryRepository.findAll();
    }

    @GetMapping("/findCategoryById/{id}")
    public ResponseEntity<CategoryModel> getCategoryById(@PathVariable("id") Long id){
        CategoryModel categoryModel = categoryRepository.findById(id).orElse(null);
        if(categoryModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(categoryModel, HttpStatus.OK);
    }

    @PutMapping("/updateCategory/{id}")
    public ResponseEntity<CategoryModel> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryModel categoryModel){

        CategoryModel category = categoryRepository.findById(id).orElse(null);
        if(category == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        category.setLabel(categoryModel.getLabel());
        CategoryModel updateCategory = categoryRepository.save(category);
        return new ResponseEntity<>(updateCategory, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
