package com.org.backendjava.dtos.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class POIRequest {
    @NotNull
    @NotEmpty
    private String name;
    @PositiveOrZero
    @NotNull
    private Integer x;
    @PositiveOrZero
    @NotNull
    private Integer y;
}
