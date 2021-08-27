package com.madhan.schooldatabase.repository;

import com.madhan.schooldatabase.entity.Course;
import com.madhan.schooldatabase.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course course1=Course.builder().title("DBA").credits(7)
                .build();

        Course course2=Course.builder().title("Java").credits(8)
                .build();

        Teacher teacher=Teacher.builder().firstName("Neela").lastName("veni")
                .courses(List.of(course1,course2)).build();

        teacherRepository.save(teacher);

    }

}