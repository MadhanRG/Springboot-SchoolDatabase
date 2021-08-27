package com.madhan.schooldatabase.repository;

import com.madhan.schooldatabase.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByLastNameContaining(String lastName);

    public List<Student> findByGuardianName(String guardianname);

    public List<Student> findByEmail(String email);

    //@Query("select s from student s where s.email= ?1")
    //public Student getStudentsByEmail(String email);

    @Query("select s from Student s where s.email = ?1")
    Student getStudentByEmailAddress(String email);


    @Query("select s.firstName from Student s where email = ?1")
    public String getStudentFirstNameByEmail(String email);

    @Query(value = "select * from tbl_student s where s.email_address=?1",
            nativeQuery = true
    )
    public Student getStudentByNaiveQuery(String email);

    @Query(value = "select * from tbl_student s where s.email_address = :email and s.first_name = :firstName" ,
            nativeQuery = true
    )
    public Student getStudentByNaiveQueryWithParam(@Param("email") String email,
                                                   @Param("firstName")String firstName);

    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name = ?1 where email_address = ?2",
    nativeQuery = true)
    int updateFirstNameByEmailAdderss(String first_name,String email_address);


    @Modifying
    @Transactional
    @Query(value = "delete from tbl_student where email_address = ?1",
    nativeQuery = true)
    int deleteStudentByEmailAdderss(String email_address);

}
