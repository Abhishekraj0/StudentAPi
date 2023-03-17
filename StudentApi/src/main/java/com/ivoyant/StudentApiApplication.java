package com.ivoyant;

import com.ivoyant.model.Student;
import com.ivoyant.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApiApplication implements CommandLineRunner {

	public static void main(String[] args) {SpringApplication.run(StudentApiApplication.class, args);
	}
	@Autowired
	private StudentRepo studentRepo;
	@Override
	public void run(String... args) throws Exception {


	}
}
