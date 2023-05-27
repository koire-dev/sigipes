package com.personalAdministrative.BDSigipes.controller;

import com.personalAdministrative.BDSigipes.entities.StatusModel;
import com.personalAdministrative.BDSigipes.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @PostMapping("/addStatus")
    public ResponseEntity<StatusModel> saveStatus(@RequestBody StatusModel statusModel){

        if(statusModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        StatusModel status = statusRepository.save(statusModel);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/findAllStatus")
    public List<StatusModel> getAllStatus(){
        return statusRepository.findAll();
    }

    @GetMapping("/findStatusById/{id}")
    public ResponseEntity<StatusModel> getStatusById(@PathVariable("id") Long id){

        StatusModel statusModel = statusRepository.findById(id).orElse(null);
        if(statusModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(statusModel, HttpStatus.OK);
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<StatusModel> updateStatus(@PathVariable("id") Long id, @RequestBody StatusModel statusModel){

        StatusModel status = statusRepository.findById(id).orElse(null);
        if(status == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        status.setLabel(statusModel.getLabel());
        StatusModel updateStatus = statusRepository.save(status);
        return new ResponseEntity<>(updateStatus, HttpStatus.OK);
    }

    @DeleteMapping("/deleteStatus/{id}")
    public String deleteStatus(@PathVariable("id") Long id){
        statusRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
