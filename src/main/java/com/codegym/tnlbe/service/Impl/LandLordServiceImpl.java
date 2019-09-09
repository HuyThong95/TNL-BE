package com.codegym.tnlbe.service.Impl;

import com.codegym.tnlbe.entity.LandLord;
import com.codegym.tnlbe.repository.LandLordRepository;
import com.codegym.tnlbe.service.LandLordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandLordServiceImpl implements LandLordService {
    @Autowired
    private LandLordRepository landLordRepository;
    @Override
    public List<LandLord> findAllLandLord() {
        return (List<LandLord>) landLordRepository.findAll();
    }

    @Override
    public void saveLandLord(Long id, LandLord landLord) {
        landLordRepository.save(landLord);

    }

    @Override
    public void deleteLandLord(Long id) {
        landLordRepository.deleteById(id);

    }

    @Override
    public Optional<LandLord> findLandLordById(Long id) {
        return landLordRepository.findById(id);
    }
}
