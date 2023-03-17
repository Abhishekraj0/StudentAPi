package com.ivoyant.controller;

import com.ivoyant.exception.ResourcesNotFoundException;
import com.ivoyant.model.Student;
import com.ivoyant.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping
    public List<Student> getAllStudent(){
        return studentRepo.findAll();
    }

    //create student Rest api data
   @PostMapping
   public Student createStudent(@RequestBody Student student){
        return studentRepo.save(student);
    }

    //get student data by roll no
    @GetMapping("{rollNo}")
    public ResponseEntity<Student> getStudentByRollNo(@PathVariable Integer rollNo){
        Student student = studentRepo.findById(rollNo)
                .orElseThrow(()-> new ResourcesNotFoundException("Student is not found in this Roll No. "+ rollNo));
        return ResponseEntity.ok(student);
    }
    //update student data by roll no
    @PutMapping("{rollNo}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer rollNo,@RequestBody Student studentDetails){
        Student updateStudent = studentRepo.findById(rollNo)
                .orElseThrow(()-> new ResourcesNotFoundException("Student is not found in this Roll No. "+ rollNo));
        updateStudent.setFirstName(studentDetails.getFirstName());
        updateStudent.setLastName(studentDetails.getLastName());
        updateStudent.setFatherName(studentDetails.getFatherName());
        studentDetails.setAddress(studentDetails.getAddress());
        studentDetails.setDob(studentDetails.getDob());
        studentDetails.setQualification(studentDetails.getQualification());
        studentDetails.setMobileNo(studentDetails.getMobileNo());
        studentDetails.setEmailId(studentDetails.getEmailId());

        studentRepo.save(updateStudent);
        return ResponseEntity.ok(updateStudent);
    }
    // delete
    @DeleteMapping("{rollNo}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Integer rollNo){
        Student Student = studentRepo.findById(rollNo)
                .orElseThrow(()-> new ResourcesNotFoundException("Student is not found in this Roll No. "+ rollNo));

        studentRepo.delete(Student);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
