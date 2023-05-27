package com.personalAdministrative.BDSigipes.controller;

import com.personalAdministrative.BDSigipes.entities.ClassModel;
import com.personalAdministrative.BDSigipes.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassController {

    @Autowired
    private ClassRepository classRepository;

    @PostMapping("/addClass")
    public ResponseEntity<ClassModel> saveClass(@RequestBody ClassModel classModel){
        if(classModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        ClassModel classes = classRepository.save(classModel);
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

    @GetMapping("/findAllClass")
    public List<ClassModel> getAllClass(){
        return classRepository.findAll();
    }

    @GetMapping("/findClassById/{id}")
    public ResponseEntity<ClassModel> getClassById(@PathVariable("id") Long id){
        ClassModel classModel = classRepository.findById(id).orElse(null);
        if(classModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(classModel, HttpStatus.OK);
    }

    @PutMapping("/updateClass/{id}")
    public ResponseEntity<ClassModel> updateClass(@PathVariable("id") Long id, @RequestBody ClassModel classModel){

        ClassModel classes = classRepository.findById(id).orElse(null);
        if(classes == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        classes.setLabel(classModel.getLabel());
        ClassModel updateClass = classRepository.save(classes);
        return new ResponseEntity<>(updateClass, HttpStatus.OK);
    }

    @DeleteMapping("/deleteClass/{id}")
    public String deleteClass(@PathVariable("id") Long id){
        classRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
