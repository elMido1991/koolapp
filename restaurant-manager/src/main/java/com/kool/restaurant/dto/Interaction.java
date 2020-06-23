package com.kool.restaurant.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Interaction {
	private Boolean like;
	private Boolean dislike;
}
