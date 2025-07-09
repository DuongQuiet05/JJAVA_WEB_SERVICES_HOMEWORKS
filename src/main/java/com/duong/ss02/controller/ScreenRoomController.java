package com.duong.ss02.controller;

import com.duong.ss02.entity.ScreenRoom;
import com.duong.ss02.service.ScreenRoomService;
import com.duong.ss02.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/screenrooms")
public class ScreenRoomController {

    @Autowired
    private ScreenRoomService screenRoomService;

    @Autowired
    private TheaterService theaterService;

    @GetMapping
    public String listScreenRooms(Model model) {
        model.addAttribute("screenRooms", screenRoomService.getAllScreenRooms());
        return "screenroom/list";
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("screenRoom", new ScreenRoom());
        model.addAttribute("theaters", theaterService.getAllTheaters());
        return "screenroom/add"; // trang HTML form thêm
    }

    // Xử lý thêm phòng chiếu
    @PostMapping("/add")
    public String addScreenRoom(@ModelAttribute ScreenRoom screenRoom) {
        screenRoomService.save(screenRoom);
        return "redirect:/screenrooms";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<ScreenRoom> screenRoomOpt = screenRoomService.findById(id);
        if (screenRoomOpt.isPresent()) {
            model.addAttribute("screenRoom", screenRoomOpt.get());
            model.addAttribute("theaters", theaterService.getAllTheaters());
            return "screenroom/edit";
        } else {
            return "redirect:/screenrooms";
        }
    }


    @PostMapping("/edit/{id}")
    public String updateScreenRoom(@PathVariable Long id, @ModelAttribute ScreenRoom screenRoom) {
        screenRoom.setId(id);
        screenRoomService.update(screenRoom);
        return "redirect:/screenrooms";
    }


    @PostMapping("/delete/{id}")
    public String deleteScreenRoom(@PathVariable Long id) {
        screenRoomService.delete(id);
        return "redirect:/screenrooms";
    }
}