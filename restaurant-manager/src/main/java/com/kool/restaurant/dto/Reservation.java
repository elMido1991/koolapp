package com.kool.restaurant.dto;

import java.util.Date;
import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Reservation {
	private Long reservationId;
	private String reservationCode;
	private ReservationStatus status;
	private Integer restaurantId;
	private Set<Plat> dishList;
	private Date reservationDate;
	private Boolean ongoingReservation;
}
