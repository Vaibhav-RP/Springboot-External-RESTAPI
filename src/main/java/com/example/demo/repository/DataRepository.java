package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.DataEntity;


@Repository
public interface DataRepository extends JpaRepository<DataEntity,Integer> {

}
