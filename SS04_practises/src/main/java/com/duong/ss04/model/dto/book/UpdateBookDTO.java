package com.duong.ss04.model.dto.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UpdateBookDTO {
    private int id;
    private int categoryId;
    private String name;
    private String author;
    private String publisher;
    private Date publicYear;
    private Double price;
}
