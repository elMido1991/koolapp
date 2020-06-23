package com.kool.restaurant.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestaurantCrowd {
	private Integer capacity;
	private Integer realTime;
}
