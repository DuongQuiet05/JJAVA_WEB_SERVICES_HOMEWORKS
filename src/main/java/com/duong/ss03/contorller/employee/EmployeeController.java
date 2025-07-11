package com.duong.ss03.contorller.employee;

import com.duong.ss03.model.dto.CreateEmployeeDTO;
import com.duong.ss03.model.dto.DisplayEmployeeDTO;
import com.duong.ss03.model.dto.PaginationDTO;
import com.duong.ss03.model.dto.UpdateEmployeeDTO;
import com.duong.ss03.model.entity.Employee;
import com.duong.ss03.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public String showList (
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "5") int size,
            Model model){
        PaginationDTO dto = employeeService.getPaginateDTO(page - 1, size);


        model.addAttribute("employees",dto.getDisplayEmployeeDTOS());
        model.addAttribute("totalPages", dto.getTotalPages());
        model.addAttribute("currentPage",page);
        model.addAttribute("hasNext", dto.isHasNext());
        model.addAttribute("size",size);
        return "employee/list";
    }

//    @GetMapping("/{id}")
//    public String showDetail (@PathVariable("id") int id, Model model){
//        model.addAttribute("detail", employeeService.findEmployeeById(id).get());
//        return "employee/detail";
//    }

    @GetMapping("/add")
    public String showAdd (Model model){
        model.addAttribute("createDTO",new CreateEmployeeDTO());
        return "employee/add";
    }

    @PostMapping("/add")
    public String handleAdd (@ModelAttribute("createDTO") CreateEmployeeDTO dto){
        if(!employeeService.addEmployee(dto)){
            return "employee/add";
        }
        return "redirect:/employees";
    }


    @GetMapping("/edit/{id}")
    public String showEdit (@PathVariable("id") int id, Model model){
        Optional<Employee > employeeOptional = employeeService.findEmployeeById(id);
        if(employeeOptional.isEmpty()) return "employee/list";

        Employee old = employeeOptional.get();

        model.addAttribute("updateDTO",new UpdateEmployeeDTO(
                old.getId(),
                old.getName(),
                old.getEmail(),
                old.getPhone(),
                old.getSalary()
        ));
        return "employee/edit";
    }

    @PostMapping("/edit")
    public String handleEdit (@ModelAttribute("updateDTO") UpdateEmployeeDTO dto){
        if(!employeeService.editEmployee(dto)){
            return "employee/edit";
        }

        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String handleDelete (@PathVariable("id") int id){
        if(!employeeService.deleteEmployeeById(id)){
            return "employee/list";
        }
        return "redirect:/employees";
    }
}
