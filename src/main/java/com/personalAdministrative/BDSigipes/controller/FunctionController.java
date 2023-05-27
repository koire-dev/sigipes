package com.personalAdministrative.BDSigipes.controller;

import com.personalAdministrative.BDSigipes.entities.FunctionModel;
import com.personalAdministrative.BDSigipes.repository.FunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FunctionController {

    @Autowired
    private FunctionRepository functionRepository;

    @PostMapping("/addFunction")
    public ResponseEntity<FunctionModel> saveFunction(@RequestBody FunctionModel functionModel){
        if(functionModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        FunctionModel function = functionRepository.save(functionModel);
        return new ResponseEntity<>(function, HttpStatus.OK);
    }

    @GetMapping("/findAllFunction")
    public List<FunctionModel> getAllFunction(){
        return functionRepository.findAll();
    }

    @GetMapping("/findFunctionById/{id}")
    public ResponseEntity<FunctionModel> getFunctionById(@PathVariable("id") Long id){
        FunctionModel functionModel = functionRepository.findById(id).orElse(null);

        if(functionModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(functionModel, HttpStatus.OK);
    }

    @PutMapping("/updateFunction/{id}")
    public ResponseEntity<FunctionModel> updateFunction(@PathVariable("id") Long id, @RequestBody FunctionModel functionModel){

        FunctionModel function = functionRepository.findById(id).orElse(null);
        if(function == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        function.setLabel(functionModel.getLabel());
        FunctionModel updateFunction = functionRepository.save(function);
        return new ResponseEntity<>(updateFunction, HttpStatus.OK);
    }

    @DeleteMapping("/deleteFunction/{id}")
    public String deleteFunction(@PathVariable("id") Long id){
        functionRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
