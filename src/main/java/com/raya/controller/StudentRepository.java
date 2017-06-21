package com.raya.controller;

import com.raya.model.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by raya on 6/20/17.
 */
public interface StudentRepository extends CrudRepository<Student,Integer>{

}
