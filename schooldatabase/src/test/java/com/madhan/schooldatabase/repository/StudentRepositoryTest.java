package com.madhan.schooldatabase.repository;

import com.madhan.schooldatabase.entity.Guardian;
import com.madhan.schooldatabase.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student=Student.builder().firstName("Mike").lastName("Johnson").email("mike65@gmail,com")
                //guardianName("Sara").guardianEmail("sara678@gmail.com").guardianMobile("9876543210")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList=studentRepository.findAll();
        System.out.println("student list are" +studentList);
    }

    @Test
    public void saveWithGuardian(){
        Guardian guardian=Guardian.builder().name("ravichandran").email("ravichandran78@gmail.com")
                .mobile("987656789").build();

        Student student=Student.builder().firstName("madhu").lastName("shree").email("madhu87@gmail.com")
                        .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void findStudentsByFirstName(){

        List<Student> students=studentRepository.findByFirstName("MADhu");
        System.out.println("the student name is"+students);
    }

    @Test
    public void findStudentsByLatNameContaining(){
        List<Student> students=studentRepository.findByLastNameContaining("sree");
        System.out.println("the last name is" +students);
    }

    @Test
    public void printStudentsBasedGuardianName(){
        List<Student> students=studentRepository.findByGuardianName("ravichandran");
        System.out.println("the guardian of student is "+students);
    }

    @Test
    public void printStudentsBasedEmail(){
        Student students=studentRepository.getStudentByEmailAddress("madhu87@gmail.com");
        System.out.println("the email of student is "+students);
    }

    @Test
    public void getStudentFirstNameByEmail(){
        String firstName=studentRepository.getStudentFirstNameByEmail("madhu87@gmail.com");
        System.out.println("firstName" + firstName);
    }

    @Test
    public void printStudentsBasedEmailByNative(){
        Student student=studentRepository.getStudentByNaiveQuery("madhu87@gmail.com");
        System.out.println("the email from native query is " + student);
    }

    @Test
    public void printStudentsBasedEmailByNativeParam(){
        Student student=studentRepository.getStudentByNaiveQueryWithParam("madhu87@gmail.com","madhu");
        System.out.println("the email from native query is " + student);
    }

    @Test
    public void updateFirstNameByEmailAdderssTest(){
        studentRepository.updateFirstNameByEmailAdderss("Akshaya",
                "madhu87@gmail.com");
    }

    @Test
    public void deleteStudentTest(){
        studentRepository.deleteStudentByEmailAdderss("madhu87@gmail.com");
    }

    @Test
    public void saveStudentAddition(){

        Guardian guardian=Guardian.builder().name("shamrmila").email("sharmaila4m@gmail.com")
                .mobile("09678904321").build();

        Student student=Student.builder().firstName("Akshara").lastName("hashan").
                email("akshara34j@gmail.com").guardian(guardian)
                .build();
        studentRepository.save(student);
    }



}