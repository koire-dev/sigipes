package com.personalAdministrative.BDSigipes.controller;

import com.personalAdministrative.BDSigipes.entities.PersonnelModel;
import com.personalAdministrative.BDSigipes.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonnelController {

    @Autowired
    private PersonnelRepository personnelRepository;

    @PostMapping("/addPersonnel")
    public ResponseEntity<PersonnelModel> savePersonnel(@RequestBody PersonnelModel personnelModel){

        if(personnelModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        PersonnelModel personnel = personnelRepository.save(personnelModel);
        return new ResponseEntity<>(personnel, HttpStatus.OK);
    }

    @GetMapping("/findAllPersonnel")
    public List<PersonnelModel> getAllPersonnel(){
        return personnelRepository.findAll();
    }

    @GetMapping("/findPersonnelByNumber/{number}")
    public ResponseEntity<PersonnelModel> getPersonnelByNumber(@PathVariable("number") String number){

        PersonnelModel personnel = personnelRepository.findById(number).orElse(null);
        if(personnel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(personnel, HttpStatus.OK);
    }

    @PutMapping("/updatePersonnel/{number}")
    public ResponseEntity<PersonnelModel> updatePersonnel(@PathVariable("number") String number, @RequestBody PersonnelModel personnelModel){

        PersonnelModel personnel = personnelRepository.findById(number).orElse(null);
        if(personnel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        personnel.setAdministration(personnelModel.getAdministration());
        personnel.setDate_hiring(personnelModel.getDate_hiring());
        personnel.setDate_retirement(personnelModel.getDate_retirement());
        personnel.setDate_birth(personnelModel.getDate_birth());
        personnel.setIndices_sold(personnelModel.getIndices_sold());
        personnel.setLieu_birth(personnelModel.getLieu_birth());
        personnel.setName(personnelModel.getName());

        PersonnelModel updatePersonnel = personnelRepository.save(personnel);
        return new ResponseEntity<>(updatePersonnel, HttpStatus.OK);
    }

    @DeleteMapping("/deletePersonnel/{number}")
    public String deletePersonnel(@PathVariable("number") String number){
        personnelRepository.deleteById(number);
        return "Deleted Successfully";
    }
}
