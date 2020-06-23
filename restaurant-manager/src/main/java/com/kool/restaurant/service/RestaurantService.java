package com.kool.restaurant.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.kool.restaurant.dto.Interaction;
import com.kool.restaurant.dto.Plat;
import com.kool.restaurant.dto.PlatCategory;
import com.kool.restaurant.dto.Reservation;
import com.kool.restaurant.dto.ReservationCondition;
import com.kool.restaurant.dto.Restaurant;
import com.kool.restaurant.dto.RestaurantCrowd;

@Service
public interface RestaurantService {

	Set<Restaurant> getRestaurantList();

	boolean setRestaurantFavorite(Integer restaurantId);

	RestaurantCrowd getRestaurantCrowdsInRealTime(Integer restaurantId);

	Set<PlatCategory> getListOfDishesMenuOfRestaurantByDate(Integer restaurantId, String date);

	boolean addDishesMenuToFavoriteList(Integer restaurantId, Integer dishId);

	boolean addCommentToDishesMenu(Integer dishId, String comment);

	boolean setInteractionToDishesMenu(Integer dishId, Boolean like, Boolean dislike);

	Interaction getinteractions(Integer dishId);

	Plat getDetailOfDish(Integer dishId);

	Reservation confirmReservationOfListOfDishes(Integer[] listofDishs, Integer restuarantId);

	ReservationCondition getConditionsReservationDishByRestaurant(Integer restuarantId);

	Reservation getMyReservationOfSpecificDay(Integer restaurantId, String date);

	Set<Reservation> getAllMyHistoryOfReservation(Integer restaurantId);

	Reservation getOngoingReservation();

}
