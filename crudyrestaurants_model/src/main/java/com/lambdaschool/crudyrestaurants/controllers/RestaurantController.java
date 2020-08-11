package com.lambdaschool.crudyrestaurants.controllers;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.services.RestaurantServices;
import com.lambdaschool.crudyrestaurants.views.MenuCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController
{
    @Autowired
    private RestaurantServices restaurantServices;

    // http://localhost:2019/restaurants/restaurants
    @GetMapping(value = "/restaurants", produces = "application/json")
    public ResponseEntity<?> listAllRestaurants()
    {
        List<Restaurant> myList = restaurantServices.findAllRestaurants();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    // http://localhost:2019/restaurants/restaurant/10 [10 is an example path variable]
    @GetMapping(value = "/restaurant/{restaurantid}", produces = "application/json")
    public ResponseEntity<?> findRestaurantById(@PathVariable long restaurantid)
    {
        Restaurant myRestaurant = restaurantServices.findRestaurantById(restaurantid);
        return new ResponseEntity<>(myRestaurant, HttpStatus.OK);
    }

    // http://localhost:2019/restaurants/restaurant/name/Supreme%20Eats
    @GetMapping(value = "/restaurant/name/{restname}", produces = "application/json")
    public ResponseEntity<?> findRestaurantByName(@PathVariable String restname)
    {
        Restaurant myRestaurant = restaurantServices.findRestaurantByName(restname);
        return new ResponseEntity<>(myRestaurant, HttpStatus.OK);
    }

    // http://localhost:2019/restaurants/restaurant/likename/eat
    @GetMapping(value = "/restaurant/likename/{restname}", produces = "application/json")
    public ResponseEntity<?> findRestaurantByNameLike(@PathVariable String restname)
    {
        List<Restaurant> myList = restaurantServices.findAllRestaurantsByNameLike(restname);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    // http://localhost:2019/restaurants/menucount
    // this is a custom query, all others are JPA queries
    @GetMapping(value = "/menucount", produces = "application/json")
    public ResponseEntity<?> getMenuCount()
    {
        List<MenuCounts> myList = restaurantServices.getMenuCounts();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    // http://localhost:2019/restaurants/likedish/cheese
}