package com.raya;

import com.raya.controller.StudentRepository;
import com.raya.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by raya on 6/20/17.
 */

@Controller
//@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentRepository studentRepository;



    @RequestMapping ("/")
    public String home(Model model){
        model.addAttribute("student",new Student());
        return "insertForm";
    }

    @GetMapping("/add")
    public String getStudent(Model model){
        model.addAttribute(new Student());
        model.addAttribute("student", studentRepository.findAll());
        return "displayForm";
    }

    @PostMapping("/add")
    public String processStudent(@Valid Student person, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "displayForm";
        }
        studentRepository.save(person);
        return "redirect:/all";
    }

    @RequestMapping("/all")
    public String getAllStudents(Model model)
    {
        model.addAttribute("student", studentRepository.findAll());
        return "displayForm";
    }











/*

    @PostMapping(value="/add") // Map ONLY Post Requests
    public  @ResponseBody String addNewStudent(@ModelAttribute Student student) {

        studentRepository.save(student);
        return "redirect:/add";
    }

    @GetMapping("/add") // Map ONLY Post Requests
    public String getStudent(Model model) {

        Student student = new Student();
        studentRepository.save(student);
        return "isertForm";
    }

    @GetMapping("/add") // Map ONLY Post Requests
    public String getValue(Model model) {

        model.addAttribute(new Student());
        model.addAttribute("student",studentRepository.findAll());
        return "display";
    }

    @GetMapping(value="/display")
    public Iterable<Student> getAllStudents() {

        return studentRepository.findAll();
    }
*/

}
