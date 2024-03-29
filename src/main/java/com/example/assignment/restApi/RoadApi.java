package com.example.assignment.restApi;

import com.example.assignment.entity.Road;
import com.example.assignment.service.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roads")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class RoadApi {
    @Autowired
    RoadService roadService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Road>> getList() {
        return ResponseEntity.ok(roadService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Road> create(@RequestBody Road road) {
        return ResponseEntity.ok(roadService.save(road));
    }
}