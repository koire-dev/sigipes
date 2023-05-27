package com.personalAdministrative.BDSigipes.controller;

import com.personalAdministrative.BDSigipes.entities.IndicesModel;
import com.personalAdministrative.BDSigipes.repository.IndicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndicesController {

    @Autowired
    private IndicesRepository indicesRepository;

    @PostMapping("/addIndices")
    public ResponseEntity<IndicesModel> saveIndices(@RequestBody IndicesModel indicesModel){
        if(indicesModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        IndicesModel indices = indicesRepository.save(indicesModel);
        return new ResponseEntity<>(indices, HttpStatus.OK);
    }

    @GetMapping("/findAllIndices")
    public List<IndicesModel> getAllIndices(){
        return indicesRepository.findAll();
    }

    @GetMapping("/findIndicesById/{id}")
    public ResponseEntity<IndicesModel> getIndicesById(@PathVariable("id") Long id){
        IndicesModel indicesModel = indicesRepository.findById(id).orElse(null);
        if(indicesModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(indicesModel, HttpStatus.OK);
    }

    @PutMapping("/updateIndices/{id}")
    public ResponseEntity<IndicesModel> updateIndices(@PathVariable("id") Long id, @RequestBody IndicesModel indicesModel){

        IndicesModel indices = indicesRepository.findById(id).orElse(null);
        if(indices == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        indices.setValue(indicesModel.getValue());
        IndicesModel updateIndices = indicesRepository.save(indices);
        return new ResponseEntity<>(updateIndices, HttpStatus.OK);
    }

    @DeleteMapping("/deleteIndices/{id}")
    public String deleteIndices(@PathVariable("id") Long id){
        indicesRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
