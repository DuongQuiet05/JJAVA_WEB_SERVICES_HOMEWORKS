package com.duong.ss02.service;

import com.duong.ss02.entity.ScreenRoom;
import com.duong.ss02.repository.ScreenRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreenRoomService implements IService<ScreenRoom, Long> {

    @Autowired
    private ScreenRoomRepository screenRoomRepository;

    @Override
    public ScreenRoom save(ScreenRoom entity) {
        return screenRoomRepository.save(entity);
    }

    @Override
    public Optional<ScreenRoom> findById(Long id) {
        return screenRoomRepository.findById(id);
    }

    @Override
    public ScreenRoom update(ScreenRoom entity) {
        return screenRoomRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        screenRoomRepository.deleteById(id);
    }

    public List<ScreenRoom> getAllScreenRooms() {
        return screenRoomRepository.findAll();
    }
}