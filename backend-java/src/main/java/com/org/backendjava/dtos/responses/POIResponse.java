package com.org.backendjava.dtos.responses;

import com.org.backendjava.entities.POI;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class POIResponse {
    private Long id;
    private String name;
    private Integer x;
    private Integer y;

    public POIResponse(POI poi) {
        this.id = poi.getId();
        this.name = poi.getName();
        this.x = poi.getX();
        this.y = poi.getY();
    }

    public void setPOI(POI poi) {
        this.id = poi.getId();
        this.name = poi.getName();
        this.x = poi.getX();
        this.y = poi.getY();
    }
}
