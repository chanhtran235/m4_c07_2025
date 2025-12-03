package org.example.demo_spring_mvc.controller;


import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.example.demo_spring_mvc.entity.Student;
import org.example.demo_spring_mvc.service.IStudentService;
import org.example.demo_spring_mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {


    private IStudentService studentService;

    @ModelAttribute("subjects")
    public List<String> getSubject(){
        return List.of("JAVA","JS","PHP","HTML");
    }
    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

//    @RequestMapping(value = "/students", method = RequestMethod.GET)
//    @GetMapping(value = "/students")
//    public String showList(ModelMap model){
//        List<Student> studentList = studentService.findAll();
//        model.addAttribute("studentList",studentList);
//        return "list";
//    }
    @GetMapping(value = "")
    public ModelAndView showList(){
        List<Student> studentList = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("mess","ok");
        modelAndView.addObject("studentList",studentList);
        return modelAndView;
    }


    @GetMapping(value = "/add")
    public String showFormAdd(Model model){
        model.addAttribute("student", new Student());
//        model.addAttribute("subjects", List.of("JAVA","JS","PHP","HTML"));
        return "add";
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
        return "detail";
    }
    @GetMapping(value = "/{id:[12]}/detail")
    public String getDetail2(@PathVariable(name = "id")int id,
                            Model model){
        model.addAttribute("student",studentService.findById(id));
        return "detail";
    }



}
