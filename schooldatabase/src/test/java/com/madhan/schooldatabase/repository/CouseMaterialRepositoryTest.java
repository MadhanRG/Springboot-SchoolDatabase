package com.madhan.schooldatabase.repository;

import com.madhan.schooldatabase.entity.Course;
import com.madhan.schooldatabase.entity.CouseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CouseMaterialRepositoryTest {

    @Autowired
    private CouseMaterialRepository couseMaterialRepository;

    @Test
    public void saveCouseMaterial(){

        Course course=Course.builder().title("Nature vlogs").credits(6)
                .build();
        CouseMaterial couseMaterial=CouseMaterial.builder().url("www.google.nature.com")
                .course(course)
                .build();

        couseMaterialRepository.save(couseMaterial);
    }
    @Test
    public void printAllCouseMaterialList(){
        List<CouseMaterial> couseMaterialList=couseMaterialRepository.findAll();
        System.out.println("print all the course material list "+couseMaterialList);
    }

}