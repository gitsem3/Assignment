package com.example.assignment.service;

import com.example.assignment.entity.District;
import com.example.assignment.entity.Road;
import com.example.assignment.exception.NotFoundException;
import com.example.assignment.repository.DistrictRepository;
import com.example.assignment.repository.RoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoadService {
    @Autowired
    DistrictRepository districtRepository;
    @Autowired
    RoadRepository roadRepository;

    public Road save(Road road) {
        District district = districtRepository.findById(road.getDistrict_id()).orElse(null);
        if (district == null) {
            throw new NotFoundException("No district found!");
        }
        else {
            road.setDistrict(district);
            roadRepository.save(road);
        }
        return road;
    }
    public List<Road> findAll() {
        return roadRepository.findAll();
    }
}
