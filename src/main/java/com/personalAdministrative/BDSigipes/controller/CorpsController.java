package com.personalAdministrative.BDSigipes.controller;

import com.personalAdministrative.BDSigipes.entities.CorpsModel;
import com.personalAdministrative.BDSigipes.repository.CorpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CorpsController {

    @Autowired
    private CorpsRepository corpsRepository;

    @PostMapping("/addCorps")
    public ResponseEntity<CorpsModel> saveCorps(@RequestBody CorpsModel corpsModel){
        if(corpsModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        CorpsModel corps = corpsRepository.save(corpsModel);
        return new ResponseEntity<>(corps, HttpStatus.OK);
    }

    @GetMapping("/findAllCorps")
    public List<CorpsModel> getAllCorps(){
        return corpsRepository.findAll();
    }

    @GetMapping("/findCorpsById/{id}")
    public ResponseEntity<CorpsModel> getCorpsById(@PathVariable("id") Long id){
        CorpsModel corpsModel = corpsRepository.findById(id).orElse(null);
        if(corpsModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(corpsModel, HttpStatus.OK);
    }

    @PutMapping("/updateCorps/{id}")
    public ResponseEntity<CorpsModel> updateCorps(@PathVariable("id") Long id, @RequestBody CorpsModel corpsModel){

        CorpsModel corps = corpsRepository.findById(id).orElse(null);
        if(corps == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        corps.setLabel(corpsModel.getLabel());
        CorpsModel updateCorps = corpsRepository.save(corps);
        return new ResponseEntity<>(updateCorps, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCorps/{id}")
    public String deleteCorps(@PathVariable("id") Long id){
        corpsRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
