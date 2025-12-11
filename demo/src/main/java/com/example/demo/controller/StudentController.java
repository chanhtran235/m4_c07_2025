package com.example.demo.controller;


import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.exception.DuplicateAdminNameException;
import com.example.demo.service.IStudentService;
import com.example.demo.validate.StudentValidate;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping(value = "")
    public String showList(
                           @RequestParam(name = "page", required = false, defaultValue ="0") int page,
                           @RequestParam(name = "size", required = false, defaultValue = "20") int size,
                           @RequestParam(name = "searchName", required = false, defaultValue = "") String searchName,
                           Model model) {
        Sort sort = Sort.by("gender").ascending().and(Sort.by("name").descending());
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Student> studentPage = studentService.findAll(searchName, pageable);
        model.addAttribute("studentPage", studentPage);
        model.addAttribute("searchName", searchName);
        return "student/list";
    }


    @GetMapping(value = "/add")
    public String showFormAdd(Model model) {
        model.addAttribute("studentDto", new StudentDto());
//        model.addAttribute("subjects", List.of("JAVA","JS","PHP","HTML"));
        return "student/add";
    }

    @PostMapping(value = "/add")
    public String save(@Valid @ModelAttribute StudentDto studentDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes
    ) throws DuplicateAdminNameException {

        new StudentValidate().validate(studentDto,bindingResult);

        if (bindingResult.hasErrors()){
            return "student/add";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        studentService.save(student);
        redirectAttributes.addFlashAttribute("mess", "Them moi thanh cong");
        return "redirect:/students";
    }

    @GetMapping(value = "/detail")
    public String getDetail1(@RequestParam(name = "id", required = false, defaultValue = "3") int id,
                             Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "student/detail";
    }

    @GetMapping(value = "/{id}/detail")
    public String getDetail2(@PathVariable(name = "id") int id,
                             Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "student/detail";
    }

    @ExceptionHandler(DuplicateAdminNameException.class)
    public String handleAdminException(){
        return "client-error";
    }

}
