package com.kool.restaurant.service.impl;

import java.util.Set;

import com.kool.restaurant.dto.Interaction;
import com.kool.restaurant.dto.Plat;
import com.kool.restaurant.dto.PlatCategory;
import com.kool.restaurant.dto.Reservation;
import com.kool.restaurant.dto.ReservationCondition;
import com.kool.restaurant.dto.Restaurant;
import com.kool.restaurant.dto.RestaurantCrowd;
import com.kool.restaurant.service.RestaurantService;

public class RestaurantServiceImpl implements RestaurantService {

	@Override
	public Set<Restaurant> getRestaurantList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setRestaurantFavorite(Integer restaurantId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RestaurantCrowd getRestaurantCrowdsInRealTime(Integer restaurantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<PlatCategory> getListOfDishesMenuOfRestaurantByDate(Integer restaurantId, String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addDishesMenuToFavoriteList(Integer restaurantId, Integer dishId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCommentToDishesMenu(Integer dishId, String comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setInteractionToDishesMenu(Integer dishId, Boolean like, Boolean dislike) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Interaction getinteractions(Integer dishId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plat getDetailOfDish(Integer dishId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation confirmReservationOfListOfDishes(Integer[] listofDishs, Integer restuarantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReservationCondition getConditionsReservationDishByRestaurant(Integer restuarantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation getMyReservationOfSpecificDay(Integer restaurantId, String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Reservation> getAllMyHistoryOfReservation(Integer restaurantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation getOngoingReservation() {
		// TODO Auto-generated method stub
		return null;
	}

}
