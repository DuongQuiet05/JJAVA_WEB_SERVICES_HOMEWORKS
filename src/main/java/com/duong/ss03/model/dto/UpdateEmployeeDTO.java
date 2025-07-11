package com.duong.ss03.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeDTO {
    private int id;
    private String name;
    private String phone;
    private String email;
    private double salary;
}

