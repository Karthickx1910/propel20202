package com.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.dao.RestaurantDao;
import com.restaurant.model.RestaurantModel;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RestaurantController {

	@Autowired
	private RestaurantDao Resdao;

	@RequestMapping(value = "/ListRestaurant", method = RequestMethod.GET)
	public List getAllDetails() {
		List objlist;
		objlist = Resdao.getAllRestaurantDetails();
		return objlist;
	}

	@RequestMapping(value = "/restaurantname/{NAME}", method = RequestMethod.GET)
	public RestaurantModel getaResDetails(@PathVariable("NAME") String resName) {
		RestaurantModel model = null;
		RestaurantModel resModel = Resdao.getRestaurantByName(resName, model);

		return resModel;
	}

	// INSERTING USER

	@RequestMapping(value = "/insertRestaurant", method = RequestMethod.POST)
	public void insertDetails(@RequestBody RestaurantModel model) {
		Resdao.insertRestaurant(model);
	}

	// update 
	@RequestMapping(value = "/updateRestaurant", method = RequestMethod.PUT)
	public void updateDetails( @RequestBody RestaurantModel model) {
		Resdao.updateRestaurant(model);
	}

	// delete
	@RequestMapping(value = "/deleteRestaurant/{rID}", method = RequestMethod.DELETE)
	public void deleteDetails(@PathVariable("rID") int resId) {
		Resdao.deleteRestaurant(resId);
	}

}
