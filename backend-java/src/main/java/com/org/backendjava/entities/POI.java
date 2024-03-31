package com.org.backendjava.entities;

import com.org.backendjava.dtos.requests.POIRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "poi_tb")
public class POI implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer x;
    @Column(nullable = false)
    private Integer y;

    public POI(POIRequest request) {
        this.name = request.getName();
        this.x = request.getX();
        this.y = request.getY();
    }
}
