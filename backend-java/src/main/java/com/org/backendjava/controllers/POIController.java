package com.org.backendjava.controllers;

import com.org.backendjava.dtos.requests.POIRequest;
import com.org.backendjava.dtos.responses.POIResponse;
import com.org.backendjava.services.POIService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pois")
public class POIController {
    @Autowired
    private POIService service;

    @PostMapping
    public ResponseEntity<POIResponse> savePOI(@Valid @RequestBody POIRequest request) {
        return  ResponseEntity.status(201).body(service.savePOI(request));
    }

    @GetMapping
    public ResponseEntity<Page<POIResponse>> getAllPOI(Pageable pageable) {
        return  ResponseEntity.status(200).body(service.getAllPOI(pageable));
    }

    @GetMapping("with-calculate")
    public ResponseEntity<Page<POIResponse>> getAllPOIWithCalculate(@RequestParam Integer x, @RequestParam Integer y, @RequestParam Integer distanceMax,
                                                                    Pageable pageable) {
        return  ResponseEntity.status(200).body(service.getAllPOIWithCalculate(x, y, distanceMax, pageable));
    }
}