package com.personalAdministrative.BDSigipes.controller;

import com.personalAdministrative.BDSigipes.entities.GradeModel;
import com.personalAdministrative.BDSigipes.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GradeController {

    @Autowired
    private GradeRepository gradeRepository;

    @PostMapping("/addGrade")
    public ResponseEntity<GradeModel> saveGrade(@RequestBody GradeModel gradeModel){

        if(gradeModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        GradeModel grade = gradeRepository.save(gradeModel);
        return new ResponseEntity<>(grade, HttpStatus.OK);
    }

    @GetMapping("/findAllGrade")
    public List<GradeModel> getAllGrade(){

        return gradeRepository.findAll();
    }

    @GetMapping("/findGradeById/{id}")
    public ResponseEntity<GradeModel> getGradeById(@PathVariable("id") Long id){

        GradeModel grade = gradeRepository.findById(id).orElse(null);
        if(grade == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(grade, HttpStatus.OK);
    }

    @PutMapping("/updateGrade/{id}")
    public  ResponseEntity<GradeModel> updateGrade(@PathVariable("id") Long id, @RequestBody GradeModel gradeModel){

        GradeModel grade = gradeRepository.findById(id).orElse(null);
        if(grade == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        grade.setLabel(gradeModel.getLabel());
        GradeModel updateGrade = gradeRepository.save(grade);
        return new ResponseEntity<>(updateGrade, HttpStatus.OK);
    }

    @DeleteMapping("/deleteGrade/{id}")
    public String deleteGrade(@PathVariable("id") Long id){

        gradeRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
