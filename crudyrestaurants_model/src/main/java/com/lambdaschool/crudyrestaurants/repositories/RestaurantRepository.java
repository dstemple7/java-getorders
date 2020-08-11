package com.lambdaschool.crudyrestaurants.repositories;

import com.lambdaschool.crudyrestaurants.models.Restaurant;
import com.lambdaschool.crudyrestaurants.views.MenuCounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The CRUD Repository connecting Restaurant to the rest of the application.
 */
public interface RestaurantRepository extends CrudRepository<Restaurant, Long>
{
    Restaurant findByName(String name);

    List<Restaurant> findByNameContainingIgnoringCase(String likename);

    @Query(value = "SELECT r.name as name, count(menuid) as countmenus " +
        "FROM restaurants r LEFT JOIN menus m " +
        "ON r.restaurantid = m.restaurantid " +
        "GROUP BY r.name " +
        "ORDER BY countmenus desc ", nativeQuery = true)
    List<MenuCounts> findMenuCounts();
}