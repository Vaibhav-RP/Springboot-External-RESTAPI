package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.DataEntity;
import com.example.demo.repository.DataRepository;


@Service
public class GenderDataService {

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    DataRepository dataRepository;


    public Object findAllGender(){
        return restTemplate.getForObject("https://api.genderize.io?name=luc", Object.class);
    }
    
    @Scheduled(fixedRate = 300000)  
    public DataEntity getGenderData(){
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern(" dd-MM-yyyy  HH:mm:ss ");
        String formatedDateTime = current.format(format);
        System.out.println(" Scheduler Time  = " +formatedDateTime);

        DataEntity data = restTemplate.getForObject("https://api.genderize.io?name=luc", DataEntity.class);
        dataRepository.save(data);
        
        return data;
    }


    public List<DataEntity> getAllData(){
        return dataRepository.findAll();
    }


    public Optional<DataEntity> getDataById(int id){
        return dataRepository.findById(id);
    }


}
