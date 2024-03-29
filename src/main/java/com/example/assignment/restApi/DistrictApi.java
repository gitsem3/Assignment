package com.example.assignment.restApi;

import com.example.assignment.entity.District;
import com.example.assignment.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/district")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class DistrictApi {
    @Autowired
    DistrictService districtService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<District>> getList() {
        return ResponseEntity.ok(districtService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<District> create(@RequestBody District district) {
        return ResponseEntity.ok(districtService.save(district));
    }
}
