package com.example.api.controller;

import com.example.api.Repository.StudentRepo;
import com.example.api.models.studentinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//@crossorgin
//for angular popo peepee

@RestController
@RequestMapping("/studentAPI")
public class studentController {

 @Autowired
 StudentRepo studentRepo;
    @PostMapping("/addStudentInfo")
    public ResponseEntity<studentinfo> createStudentInfo(@RequestBody studentinfo student){
        return new ResponseEntity<studentinfo>(studentRepo.save(student), HttpStatus.CREATED);
    }


    @GetMapping("/getData")
    ResponseEntity<List<studentinfo>> getAllstudentInfo(String getData) {
     try {
         List<studentinfo> Studentreview = new ArrayList<studentinfo>();
         if(getData == null) {
             studentRepo.findAll().forEach(Studentreview::add);
         }else{
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         }
         if(Studentreview.isEmpty()) {
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         }
         return new ResponseEntity<>(Studentreview,HttpStatus.OK);

     }
     catch (Exception e){
         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
     }
    }
     @GetMapping("/Studentstuff/{name}")
        public ResponseEntity<studentinfo> returnData(@PathVariable("name") String NAME){
            Optional<studentinfo> studentdata = studentRepo.findById(NAME);
            if(studentdata.isPresent()) {
                return new ResponseEntity<>(studentdata.get(), HttpStatus.OK);
            }else{
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        }
 }
}
