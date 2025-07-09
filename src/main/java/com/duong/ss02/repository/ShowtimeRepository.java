package com.duong.ss02.repository;

import com.duong.ss02.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {

    List<Showtime> findByMovieId(Long movieId);

    List<Showtime> findByScreenRoomId(Long screenRoomId);

    @Query("""
        select s from Showtime s
        where (:movieId is null or s.movie.id = :movieId)
        and (:date is null or date(s.startTime) = :date)
        and (:theaterId is null or s.screenRoom.theater.id = :theaterId)
        and (:screenRoomId is null or s.screenRoom.id = :screenRoomId)
    """)
    List<Showtime> findByFilters(@Param("movieId") Long movieId,
                                 @Param("date") LocalDate date,
                                 @Param("theaterId") Long theaterId,
                                 @Param("screenRoomId") Long screenRoomId);
}