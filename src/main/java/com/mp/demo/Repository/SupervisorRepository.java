package com.mp.demo.Repository;

import com.mp.demo.model.Student;
import com.mp.demo.model.Supervisor;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface SupervisorRepository extends CrudRepository<Supervisor,Long> {



}
