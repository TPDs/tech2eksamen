package com.mp.demo.Repository;

import com.mp.demo.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long>{


}
