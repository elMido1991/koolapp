package com.kool.restaurant.dto;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlatCategory {
	private Integer idCategory;
	private String category;
	private Set<Plat> listDish;
}
