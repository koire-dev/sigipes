package com.personalAdministrative.BDSigipes.controller;

import com.personalAdministrative.BDSigipes.entities.ServiceModel;
import com.personalAdministrative.BDSigipes.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @PostMapping("/addService")
    public ResponseEntity<ServiceModel> saveService(@RequestBody ServiceModel serviceModel){

        if(serviceModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        ServiceModel service = serviceRepository.save(serviceModel);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @GetMapping("/findAllService")
    public List<ServiceModel> getAllService(){
        return serviceRepository.findAll();
    }

    @GetMapping("/findServiceById/{id}")
    public ResponseEntity<ServiceModel> getServiceById(@PathVariable("id") Long id){

        ServiceModel serviceModel = serviceRepository.findById(id).orElse(null);
        if(serviceModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(serviceModel, HttpStatus.OK);
    }

    @PutMapping("/updateService/{id}")
    public ResponseEntity<ServiceModel> updateService(@PathVariable("id") Long id, @RequestBody ServiceModel serviceModel){

        ServiceModel service = serviceRepository.findById(id).orElse(null);
        if(service == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        service.setLabel(serviceModel.getLabel());
        ServiceModel updateService = serviceRepository.save(service);
        return new ResponseEntity<>(updateService, HttpStatus.OK);
    }

    @DeleteMapping("/deleteService/{id}")
    public String deleteService(@PathVariable("id") Long id){
        serviceRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
