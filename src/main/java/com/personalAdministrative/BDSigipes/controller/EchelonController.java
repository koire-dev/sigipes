package com.personalAdministrative.BDSigipes.controller;

import com.personalAdministrative.BDSigipes.entities.EchelonModel;
import com.personalAdministrative.BDSigipes.repository.EchelonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EchelonController {

    @Autowired
    private EchelonRepository echelonRepository;

    @PostMapping("/addEchelon")
    public ResponseEntity<EchelonModel> saveEchelon(@RequestBody EchelonModel echelonModel){
        if(echelonModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        EchelonModel echelon = echelonRepository.save(echelonModel);
        return new ResponseEntity<>(echelon, HttpStatus.OK);
    }

    @GetMapping("/findAllEchelon")
    public List<EchelonModel> getAllEchelon(){
        return echelonRepository.findAll();
    }

    @GetMapping("/findEchelonById/{id}")
    public ResponseEntity<EchelonModel> getEchelonById(@PathVariable("id") Long id){
        EchelonModel echelonModel = echelonRepository.findById(id).orElse(null);
        if(echelonModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(echelonModel, HttpStatus.OK);
    }

    @PutMapping("/updateEchelon/{id}")
    public ResponseEntity<EchelonModel> updateEchelon(@PathVariable("id") Long id, @RequestBody EchelonModel echelonModel){

        EchelonModel echelon = echelonRepository.findById(id).orElse(null);
        if(echelon == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        echelon.setValue(echelonModel.getValue());
        EchelonModel updateEchelon = echelonRepository.save(echelon);
        return new ResponseEntity<>(updateEchelon, HttpStatus.OK);
    }

    @DeleteMapping("/deleteEchelon/{id}")
    public String deleteEchelon(@PathVariable("id") Long id){
        echelonRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
