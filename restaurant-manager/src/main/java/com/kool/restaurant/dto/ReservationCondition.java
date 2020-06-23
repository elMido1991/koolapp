package com.kool.restaurant.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReservationCondition {
	private Date startReservation;
	private Date endReservation;
}
