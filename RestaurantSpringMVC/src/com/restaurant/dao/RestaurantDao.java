package com.restaurant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.restaurant.model.RestaurantModel;

public class RestaurantDao {
	// connecting with mySQL
	public JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// Res_id
	// StartDateTime
	// ServiceDuration
	// Notes
	// restaurantName
	// Queries:
	private static String INSERT = "INSERT INTO RESTAURANT(StartDateTime,ServiceDuration,Notes,restaurantName,status) values (?,?,?,?,'Y')";
	private static final String LIST = "select * from RESTAURANT where status='Y'";
	private static final String SEARCH = "select * from RESTAURANT where restaurantName=? AND status='Y'";
	private static final String UPDATE = "UPDATE RESTAURANT SET StartDateTime=?,ServiceDuration=?,Notes=?,restaurantName=? where Res_id=?";
	private static final String DELETE = "UPDATE RESTAURANT SET STATUS='N' where Res_id=?";

	// Insert Restaurant
	public void insertRestaurant(RestaurantModel model) {
		template.update(INSERT, model.getStartDateTime(),
				model.getServiceDuration(), model.getNotes(),
				model.getRestaurantName());

	}

	// Update Restaurant
	public void updateRestaurant(RestaurantModel model) {
		template.update(UPDATE, model.getStartDateTime(),
				model.getServiceDuration(), model.getNotes(),
				model.getRestaurantName(),model.getRes_id());

	}

	// Listing Restaurant
	public List getAllRestaurantDetails() {
		return template.query(LIST, new RowMapper<RestaurantModel>() {

			public RestaurantModel mapRow(ResultSet rs, int row)
					throws SQLException {
				RestaurantModel resModel = new RestaurantModel();

				// Res_id
				// StartDateTime
				// ServiceDuration
				// Notes
				// restaurantName
				resModel.setRes_id(rs.getInt(1));
				resModel.setStartDateTime(rs.getDate(2));
				resModel.setServiceDuration(rs.getString(3));
				resModel.setNotes(rs.getString(4));
				resModel.setRestaurantName(rs.getString(5));
				return resModel;
			}
		});

	}

	// SearchById Restaurant
	public RestaurantModel getRestaurantByName(String resName,
			RestaurantModel model) {

		{

			return template.queryForObject(SEARCH, new Object[] {resName},
					new BeanPropertyRowMapper<RestaurantModel>(
							RestaurantModel.class));

		}
	}

	public void deleteRestaurant(int resId) {
		template.update(DELETE, resId);
		
		
	}
}
