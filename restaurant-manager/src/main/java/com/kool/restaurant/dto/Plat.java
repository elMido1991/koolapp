package com.kool.restaurant.dto;

import java.util.Set;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(exclude = "category")
public class Plat {
	private Integer dishId;
    private String dishName;
    private String dishUrlImg;
    private boolean reservation;
    private Category category; 
    private int calorie;
    private int likes;
    private int isLiked;
    private int dislikes;
    private Set<Ingredient> ingredients;
    private Set<Nutrition> nutritions;
}
