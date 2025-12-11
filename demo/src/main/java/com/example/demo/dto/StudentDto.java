package com.example.demo.dto;

import com.example.demo.entity.ClassCG;
import com.example.demo.entity.Jame;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    @NotEmpty(message = "Require input name")
//    @Pattern(regexp = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)+$", message = "Name not match!")
    private String name;
    private boolean gender;
    private ClassCG classCG;
}
