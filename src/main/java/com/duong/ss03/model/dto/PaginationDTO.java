package com.duong.ss03.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaginationDTO {
    private int totalPages;
    private long totalItems;
    private boolean hasNext;
    List<DisplayEmployeeDTO> displayEmployeeDTOS;
}
