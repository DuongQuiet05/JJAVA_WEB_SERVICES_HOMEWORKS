package com.duong.ss02.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "showtime")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "screen_room_id")
    private ScreenRoom screenRoom;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private int numberSeatEmpty;
}
