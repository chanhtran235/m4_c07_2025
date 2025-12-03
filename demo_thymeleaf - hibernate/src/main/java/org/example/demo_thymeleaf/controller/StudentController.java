package org.example.demo_thymeleaf.controller;


import org.example.demo_thymeleaf.entity.Student;
import org.example.demo_thymeleaf.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

   @Autowired
    private IStudentService studentService;


    @GetMapping(value = "")
    public String showList(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList",studentList);
        return "student/list";
    }

    @GetMapping(value = "/add")
    public String showFormAdd(Model model){
        model.addAttribute("student", new Student());
//        model.addAttribute("subjects", List.of("JAVA","JS","PHP","HTML"));
        return "student/add";
    }

    @PostMapping(value = "/add")
    public String save(@ModelAttribute Student student, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes
                       ){
        studentService.add(student);
        redirectAttributes.addFlashAttribute("mess","Them moi thanh cong");
        return "redirect:/students";
    }

    @GetMapping(value = "/detail")
    public String getDetail1(@RequestParam(name = "id",required = false,defaultValue = "3")int id,
                            Model model){
        model.addAttribute("student",studentService.findById(id));
        return "student/detail";
    }
    @GetMapping(value = "/{id}/detail")
    public String getDetail2(@PathVariable(name = "id")int id,
                            Model model){
        model.addAttribute("student",studentService.findById(id));
        return "student/detail";
    }



}
