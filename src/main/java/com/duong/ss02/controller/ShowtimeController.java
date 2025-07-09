package com.duong.ss02.controller;

import com.duong.ss02.entity.Showtime;
import com.duong.ss02.service.MovieService;
import com.duong.ss02.service.ScreenRoomService;
import com.duong.ss02.service.ShowtimeService;
import com.duong.ss02.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/showtimes")
public class ShowtimeController {

    @Autowired
    private ShowtimeService showtimeService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ScreenRoomService screenRoomService;

    @Autowired
    private TheaterService theaterService;


    @GetMapping
    public String listShowtimes(
            @RequestParam(required = false) Long movieId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(required = false) Long theaterId,
            @RequestParam(required = false) Long screenRoomId,
            Model model) {

        List<Showtime> showtimes = showtimeService.filterShowtimes(movieId, date, theaterId, screenRoomId);

        model.addAttribute("showtimes", showtimes);
        model.addAttribute("movies", movieService.getAllMovies());
        model.addAttribute("theaters", theaterService.getAllTheaters());
        model.addAttribute("screenRooms", screenRoomService.getAllScreenRooms());

        // Giữ giá trị filter đã chọn
        model.addAttribute("selectedMovieId", movieId);
        model.addAttribute("selectedDate", date);
        model.addAttribute("selectedTheaterId", theaterId);
        model.addAttribute("selectedScreenRoomId", screenRoomId);

        return "showtime/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("showtime", new Showtime());
        model.addAttribute("movies", movieService.getAllMovies());
        model.addAttribute("screenRooms", screenRoomService.getAllScreenRooms());
        return "showtime/add";
    }


    @PostMapping("/add")
    public String addShowtime(@ModelAttribute Showtime showtime) {
        showtimeService.save(showtime);
        return "redirect:/showtimes";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Showtime> showtimeOpt = showtimeService.findById(id);
        if (showtimeOpt.isPresent()) {
            model.addAttribute("showtime", showtimeOpt.get());
            model.addAttribute("movies", movieService.getAllMovies());
            model.addAttribute("screenRooms", screenRoomService.getAllScreenRooms());
            return "showtime/edit";
        } else {
            return "redirect:/showtimes";
        }
    }


    @PostMapping("/edit/{id}")
    public String updateShowtime(@PathVariable Long id, @ModelAttribute Showtime showtime) {
        showtime.setId(id);
        showtimeService.update(showtime);
        return "redirect:/showtimes";
    }


    @PostMapping("/delete/{id}")
    public String deleteShowtime(@PathVariable Long id) {
        showtimeService.delete(id);
        return "redirect:/showtimes";
    }



}