package com.restaurant.model;

import java.sql.Date;



public class RestaurantModel {
	/*
	 * Res_id StartDateTime ServiceDuration Notes restaurantName
	 */

	// Date date=new Date();

	private Integer Res_id;
	private Date StartDateTime;
	private String ServiceDuration;
	private String Notes;
	private String restaurantName;
	private String status;

	public RestaurantModel() {
		// TODO Auto-generated constructor stub
	}

	public RestaurantModel(Integer res_id, Date startDateTime,
			String serviceDuration, String notes, String restaurantName,
			String status) {
		super();
		Res_id = res_id;
		StartDateTime = startDateTime;
		ServiceDuration = serviceDuration;
		Notes = notes;
		this.restaurantName = restaurantName;
		this.status = status;

	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Integer getRes_id() {
		return Res_id;
	}

	public void setRes_id(int i) {
		Res_id = i;
	}

	public Date getStartDateTime() {
		return StartDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		StartDateTime = startDateTime;
	}

	public String getServiceDuration() {
		return ServiceDuration;
	}

	public void setServiceDuration(String serviceDuration) {
		ServiceDuration = serviceDuration;
	}

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String notes) {
		Notes = notes;
	}

	@Override
	public String toString() {
		return "Model [Res_id=" + Res_id + ", StartDateTime=" + StartDateTime
				+ ", ServiceDuration=" + ServiceDuration + ", Notes=" + Notes
				+ "]";
	}

}
