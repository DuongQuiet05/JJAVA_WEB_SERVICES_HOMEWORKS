package com.duong.ss02.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "screen_room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScreenRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;
}
