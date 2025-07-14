package com.duong.ss04.model.dto.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreateBookDTO {
    private int categoryId;
    private String name;
    private String author;
    private String publisher;
    private Date publicYear;
    private Double price;
}
