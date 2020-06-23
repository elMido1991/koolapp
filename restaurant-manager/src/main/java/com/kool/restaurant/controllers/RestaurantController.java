package com.kool.restaurant.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kool.restaurant.dto.Interaction;
import com.kool.restaurant.dto.Plat;
import com.kool.restaurant.dto.PlatCategory;
import com.kool.restaurant.dto.Reservation;
import com.kool.restaurant.dto.ReservationCondition;
import com.kool.restaurant.dto.Restaurant;
import com.kool.restaurant.dto.RestaurantCrowd;
import com.kool.restaurant.service.RestaurantService;

@RestController
@RequestMapping("/v1/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("/list")
	public Set<Restaurant> viewRestaurantList() {
		return restaurantService.getRestaurantList();
	}
	
	@PostMapping("/setFavori")
	public HttpStatus setRestaurantFavorite(@RequestParam Integer restaurantId){
		boolean isTreatmentOk = restaurantService.setRestaurantFavorite(restaurantId);
		return isTreatmentOk ? HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR;
	}
	
	@GetMapping("/realTime/{restaurantId}")
	public RestaurantCrowd viewRestaurantCrowdsInRealTime(@PathVariable Integer restaurantId) {
		return restaurantService.getRestaurantCrowdsInRealTime(restaurantId);
	}
	
	@GetMapping("/menu")
	public Set<PlatCategory> viewListOfDishesMenuOfRestaurantByDate(@RequestParam Integer restaurantId,@RequestParam String date) {
		return restaurantService.getListOfDishesMenuOfRestaurantByDate(restaurantId,date);
	}
	
	@PostMapping("/menu/dish/setfavori")
	public HttpStatus addDishesMenuToFavoriteList(@RequestParam Integer restaurantId,@RequestParam Integer dishId){
		boolean isTreatmentOk = restaurantService.addDishesMenuToFavoriteList(restaurantId,dishId);
		if(!isTreatmentOk)
			throw new RuntimeException("KO");
		return HttpStatus.OK;
	}
	
	@PostMapping("/menu/dish/setComment")
	public HttpStatus addCommentToDishesMenu(@RequestParam Integer dishId, @RequestParam String comment){
		boolean isTreatmentOk = restaurantService.addCommentToDishesMenu(dishId,comment);
		if(!isTreatmentOk)
			throw new RuntimeException("KO");
		return HttpStatus.OK;
	}
	
	
	@PostMapping("/menu/dish/setinteraction")
	public HttpStatus setInteractionToDishesMenu(@RequestParam Integer dishId, @RequestParam Boolean like, @RequestParam Boolean dislike){
		boolean isTreatmentOk = restaurantService.setInteractionToDishesMenu(dishId,like,dislike);
		if(!isTreatmentOk)
			throw new RuntimeException("KO");
		return HttpStatus.OK;
	}
	
	
	@GetMapping("/menu/dish/getinteractions/{dishId}")
	public Interaction getInteractions(@PathVariable Integer dishId) {
		return restaurantService.getinteractions(dishId);
	}
	
	
	@GetMapping("/menu/dish/getinteractions/{dishId}")
	public Plat getDetailOfDish(@PathVariable Integer dishId) {
		return restaurantService.getDetailOfDish(dishId);
	}
	
	@PostMapping("/reservation")
	public Reservation confirmReservationOfListOfDishes(@RequestParam Integer[] listofDishs,@RequestParam Integer restaurantId){
		return restaurantService.confirmReservationOfListOfDishes(listofDishs,restaurantId);
	}
	
	@GetMapping("/reservation/condition/{restaurantId}")
	public ReservationCondition viewConditionsReservationDishByRestaurant(@PathVariable Integer restaurantId) {
		return restaurantService.getConditionsReservationDishByRestaurant(restaurantId);
	}
	
	@GetMapping("/getreservation")
	public Reservation viewMyReservationOfSpecificDay(@RequestParam Integer restaurantId,@RequestParam String date) {
		return restaurantService.getMyReservationOfSpecificDay(restaurantId, date);
	}
	
	@GetMapping("/listreservation")
	public Set<Reservation> viewAllMyHistoryOfReservation(@RequestParam Integer restaurantId) {
		return restaurantService.getAllMyHistoryOfReservation(restaurantId);
	}
	
	@GetMapping("/ongoing")
	public Reservation getOngoingReservation() {
		return restaurantService.getOngoingReservation();
	}
}
