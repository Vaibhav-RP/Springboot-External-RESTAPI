package com.example.demo.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.DataEntity;
import com.example.demo.service.GenderDataService;


@RestController
public class GenderDataController {

    @Autowired
    private GenderDataService genderDataService;


    // when we hit  http://localhost:8080/api  data will be added to the database.
    @GetMapping("/api")                    
    public ResponseEntity<DataEntity> saveGenderData(){
        DataEntity data =  genderDataService.getGenderData();
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }


    // when we hit  http://localhost:8080/get-all-data  all data present in the database will be displayed.
    @GetMapping("/get-all-data")           
    public ResponseEntity<List<DataEntity>> getAll(){
        
        List<DataEntity> data = genderDataService.getAllData();

        if (data.isEmpty()) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else
          return new ResponseEntity<>(data, HttpStatus.CREATED);
    }
    


    // when we hit  http://localhost:8080/get-data/id  data of that id will be displayed.
    @GetMapping("/get-data/{id}")           
    public ResponseEntity<DataEntity> getById(@PathVariable("id") int id){
        Optional<DataEntity> data = genderDataService.getDataById(id);

        if (data.isEmpty()) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else
          return new ResponseEntity<>(data.get(), HttpStatus.CREATED);
      }
    }

  
    

