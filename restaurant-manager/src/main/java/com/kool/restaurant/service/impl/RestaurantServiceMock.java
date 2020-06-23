package com.kool.restaurant.service.impl;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kool.restaurant.dto.Category;
import com.kool.restaurant.dto.Ingredient;
import com.kool.restaurant.dto.Interaction;
import com.kool.restaurant.dto.Nutrition;
import com.kool.restaurant.dto.Plat;
import com.kool.restaurant.dto.PlatCategory;
import com.kool.restaurant.dto.Reservation;
import com.kool.restaurant.dto.ReservationCondition;
import com.kool.restaurant.dto.Restaurant;
import com.kool.restaurant.dto.RestaurantCrowd;
import com.kool.restaurant.service.RestaurantService;

@Service
public class RestaurantServiceMock implements RestaurantService {

	
	private SecureRandom secureRandom;
	
	@Autowired
	public void init() {
		secureRandom = new SecureRandom();
	}
	
	
	@Override
	public Set<Restaurant> getRestaurantList() {
		// TODO Auto-generated method stub
		Restaurant restaurant1 = Restaurant.builder().isFavori(true).restaurantId(1).restaurantImage("img1.png").restaurantName("REST1").build();
		Restaurant restaurant2 = Restaurant.builder().isFavori(true).restaurantId(2).restaurantImage("img1.png").restaurantName("REST2").build();
		Restaurant restaurant3 = Restaurant.builder().isFavori(true).restaurantId(3).restaurantImage("img3.png").restaurantName("REST3").build();
		return new HashSet<Restaurant>(Arrays.asList(restaurant1,restaurant2, restaurant3));
	}

	@Override
	public boolean setRestaurantFavorite(Integer restaurantId) {
		return true;
	}

	@Override
	public RestaurantCrowd getRestaurantCrowdsInRealTime(Integer restaurantId) {
		return RestaurantCrowd.builder().capacity(secureRandom.nextInt(50)).realTime(secureRandom.nextInt(100)).build();
	}


	@Override
	public Set<PlatCategory> getListOfDishesMenuOfRestaurantByDate(Integer restaurantId, String date) {
		Plat plat1 = Plat.builder().calorie(100).dishId(1).dishName("PIZZA").dishUrlImg("image1.png").dislikes(111).isLiked(-1).likes(100).reservation(false).build();
		Plat plat2 = Plat.builder().calorie(120).dishId(2).dishName("SALADE NICOISE").dishUrlImg("image2.png").dislikes(112).isLiked(-1).likes(150).reservation(false).build();
		Plat plat3 = Plat.builder().calorie(130).dishId(3).dishName("TAJINE KAFTA").dishUrlImg("image3.png").dislikes(113).isLiked(1).likes(1110).reservation(false).build();
		Plat plat4 = Plat.builder().calorie(140).dishId(4).dishName("TACOS POULET").dishUrlImg("image4.png").dislikes(124).isLiked(-1).likes(2100).reservation(false).build();
		Plat plat5 = Plat.builder().calorie(150).dishId(5).dishName("SANDWICH THON").dishUrlImg("image5.png").dislikes(116).isLiked(1).likes(1200).reservation(false).build();
		Plat plat6 = Plat.builder().calorie(160).dishId(6).dishName("PANNACOTA").dishUrlImg("image6.png").dislikes(199).isLiked(1).likes(2300).reservation(false).build();
		PlatCategory platCategory1 = PlatCategory.builder().category("PRINCIPALE").idCategory(1).build();
		platCategory1.setListDish(new HashSet<Plat>(Arrays.asList(plat1,plat2)));
		PlatCategory platCategory2 = PlatCategory.builder().category("SALADE").idCategory(2).build();
		platCategory2.setListDish(new HashSet<Plat>(Arrays.asList(plat3,plat4)));
		PlatCategory platCategory3 = PlatCategory.builder().category("DESSERT").idCategory(3).build();
		platCategory3.setListDish(new HashSet<Plat>(Arrays.asList(plat5,plat6)));
		plat1.setCategory(Category.dessert);
		plat2.setCategory(Category.dessert);
		plat3.setCategory(Category.starter);
		plat4.setCategory(Category.starter);
		plat5.setCategory(Category.dish);
		plat6.setCategory(Category.dish);
		plat1.setIngredients(new HashSet<Ingredient>(Arrays.asList(new Ingredient("ingredient1","",""),new Ingredient("ingredient2","",""))));
		plat2.setIngredients(new HashSet<Ingredient>(Arrays.asList(new Ingredient("ingredient2","",""),new Ingredient("ingredient3","",""))));
		plat3.setIngredients(new HashSet<Ingredient>(Arrays.asList(new Ingredient("ingredient3","",""),new Ingredient("ingredient4","",""))));
		plat4.setIngredients(new HashSet<Ingredient>(Arrays.asList(new Ingredient("ingredient4","",""),new Ingredient("ingredient5","",""))));
		plat5.setIngredients(new HashSet<Ingredient>(Arrays.asList(new Ingredient("ingredient5","",""),new Ingredient("ingredient6","",""))));
		plat6.setIngredients(new HashSet<Ingredient>(Arrays.asList(new Ingredient("ingredient6","",""),new Ingredient("ingredient7","",""))));
		
		plat1.setNutritions(new HashSet<Nutrition>(Arrays.asList(new Nutrition("nutrition1",""),new Nutrition("nutrition2",""))));
		plat2.setNutritions(new HashSet<Nutrition>(Arrays.asList(new Nutrition("nutrition2",""),new Nutrition("nutrition3",""))));
		plat3.setNutritions(new HashSet<Nutrition>(Arrays.asList(new Nutrition("nutrition3",""),new Nutrition("nutrition4",""))));
		plat4.setNutritions(new HashSet<Nutrition>(Arrays.asList(new Nutrition("nutrition4",""),new Nutrition("nutrition5",""))));
		plat5.setNutritions(new HashSet<Nutrition>(Arrays.asList(new Nutrition("nutrition5",""),new Nutrition("nutrition6",""))));
		plat6.setNutritions(new HashSet<Nutrition>(Arrays.asList(new Nutrition("nutrition6",""),new Nutrition("nutrition7",""))));
		return new HashSet<PlatCategory>(Arrays.asList(platCategory1,platCategory2,platCategory3));
	}


	@Override
	public boolean addDishesMenuToFavoriteList(Integer restaurantId, Integer dishId) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addCommentToDishesMenu(Integer dishId, String comment) {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean setInteractionToDishesMenu(Integer dishId, Boolean like, Boolean dislike) {
		return true;
	}


	@Override
	public Interaction getinteractions(Integer dishId) {
		return Interaction.builder().dislike(false).like(true).build();
	}


	@Override
	public Plat getDetailOfDish(Integer dishId) {
		Plat plat1 = Plat.builder().calorie(100).dishId(1).dishName("PIZZA").dishUrlImg("image1.png").dislikes(111).isLiked(-1).likes(100).reservation(false).build();
		plat1.setCategory(Category.dish);
		plat1.setIngredients(new HashSet<Ingredient>(Arrays.asList(new Ingredient("ingredient1","",""),new Ingredient("ingredient2","",""))));
		plat1.setNutritions(new HashSet<Nutrition>(Arrays.asList(new Nutrition("nutrition1",""),new Nutrition("nutrition2",""))));
		return plat1;
	}


	@Override
	public Reservation confirmReservationOfListOfDishes(Integer[] listofDishs, Integer restuarantId) {
		// TODO Auto-generated method stub
		String reservationCode = String.valueOf(secureRandom.nextInt(300000000));
		return Reservation.builder().reservationCode(reservationCode).build();
	}


	@Override
	public ReservationCondition getConditionsReservationDishByRestaurant(Integer restuarantId) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		c.set(Calendar.AM_PM, Calendar.AM);
		c.set(Calendar.HOUR, 7);
		c.set(Calendar.MINUTE, 0);
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.AM_PM, Calendar.AM);
		c2.set(Calendar.HOUR, 10);
		c2.set(Calendar.MINUTE, 30);
		return ReservationCondition.builder().startReservation(c.getTime()).endReservation(c2.getTime()).build();
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
