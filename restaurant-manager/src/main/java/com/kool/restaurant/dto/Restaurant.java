package com.kool.restaurant.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Restaurant {
    private Integer restaurantId;
    private String  restaurantName;
    private String restaurantImage;
    private boolean isFavori;
}
