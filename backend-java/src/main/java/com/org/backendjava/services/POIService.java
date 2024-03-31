package com.org.backendjava.services;

import com.org.backendjava.dtos.requests.POIRequest;
import com.org.backendjava.dtos.responses.POIResponse;
import com.org.backendjava.entities.POI;
import com.org.backendjava.repositories.POIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class POIService {
    @Autowired
    private POIRepository repository;

    public POIResponse savePOI(POIRequest request) {
        POI poi = new POI(request);
        return new POIResponse(repository.save(poi));
    }

    public Page<POIResponse> getAllPOI(Pageable pageable) {
        Page<POI> pois = repository.findAll(pageable);
        return pois.map(POIResponse::new);
    }

    public Page<POIResponse> getAllPOIWithCalculate(int x, int y, int distanceMax, Pageable pageable) {
        Page<POI> pois = repository.findAll(pageable);
        return pois.map((val) -> {
            double distance = calculateDistance(x, y, val.getX(), val.getY());
            POIResponse response = new POIResponse();

            if (distance <= distanceMax) {
                response = new POIResponse(val);
            }

            return response;
        });
    }

    private Double calculateDistance(double x1, double y2, double x2, double y1) {
        double diferenceX = x2 - x1;
        double diferenceY = y2 - y1;
        return Math.sqrt(diferenceX * diferenceX + diferenceY * diferenceY);
    }
}
