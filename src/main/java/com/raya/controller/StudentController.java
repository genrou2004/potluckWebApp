package com.raya.controller;

import com.raya.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by raya on 6/20/17.
 */

@Controller
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentRepository studentRepository;

    /**
     * GET /create  --> Create a new Student and save it in the database.
     */
    @PostMapping("/add") // Map ONLY GET Requests
    public @ResponseBody String addNewStudent (@RequestParam String name
            , @RequestParam String foodType) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

       Student student = new Student();
        student.setFirstName(name);
        student.setFoodType(foodType);
        studentRepository.save(student);
        return "insertForm";
    }

    /*@RequestMapping("/create")
    public Student create(Student student) {
        student.setFirstName(student.getFirstName());
        student.setFoodType(student.getFoodType());
        student = studentRepository.save(student);
        return student;
    }*/


    /**
     * GET /read  --> Read a person by booking id from the database.
     */

    @GetMapping("/all")
    public @ResponseBody Iterable<Student> getAllStudents() {
        // This returns a JSON or XML with the users
        return studentRepository.findAll();
    }
  /*  @RequestMapping("/read")
    public Student read(@RequestParam  int id) {
        Student person = studentRepository.findById(id);
        return person;
    }*/
}
