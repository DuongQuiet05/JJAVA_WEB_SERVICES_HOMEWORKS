package com.duong.ss03.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CreateEmployeeDTO {
    private String name;
    private String phone;
    private String email;
    private double salary;
}
