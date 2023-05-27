package com.personalAdministrative.BDSigipes.controller;

import com.personalAdministrative.BDSigipes.entities.TypePersonnelModel;
import com.personalAdministrative.BDSigipes.repository.TypePersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TypePersonnelController {

    @Autowired
    public TypePersonnelRepository typePersonnelRepository;

    @PostMapping("/addTypePersonnel")
    public ResponseEntity<TypePersonnelModel> saveTypePersonnel(@RequestBody TypePersonnelModel typePersonnelModel){

        if(typePersonnelModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        TypePersonnelModel typePersonnel = typePersonnelRepository.save(typePersonnelModel);
        return new ResponseEntity<>(typePersonnel, HttpStatus.OK);
    }

    @GetMapping("/findAllTypePersonnel")
    public List<TypePersonnelModel> getAllTypePersonnel(){
        return typePersonnelRepository.findAll();
    }

    @GetMapping("/findTypePersonnelById/{id}")
    public ResponseEntity<TypePersonnelModel> getTypePersonnelById(@PathVariable("id") Long id){

        TypePersonnelModel typePersonnelModel = typePersonnelRepository.findById(id).orElse(null);
        if(typePersonnelModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(typePersonnelModel, HttpStatus.OK);
    }

    @PutMapping("/updateTypePersonnel/{id}")
    public ResponseEntity<TypePersonnelModel> updateTypePersonnel(@PathVariable("id") Long id, @RequestBody TypePersonnelModel typePersonnelModel){

        TypePersonnelModel typePersonnel = typePersonnelRepository.findById(id).orElse(null);
        if(typePersonnel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        typePersonnel.setLabel(typePersonnelModel.getLabel());
        TypePersonnelModel updateTypePersonnel = typePersonnelRepository.save(typePersonnel);
        return new ResponseEntity<>(updateTypePersonnel, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTypePersonnel/{id}")
    public String deleteTypePersonnel(@PathVariable("id") Long id){
        typePersonnelRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
