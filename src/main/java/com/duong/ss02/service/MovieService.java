package com.duong.ss02.service;

import com.duong.ss02.entity.Movie;
import com.duong.ss02.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements IService<Movie, Long> {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie save(Movie entity) {
        return movieRepository.save(entity);
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public Movie update(Movie entity) {
        // Có thể thêm check exists ở đây nếu cần
        return movieRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
