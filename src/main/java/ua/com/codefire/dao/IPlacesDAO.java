
package ua.com.codefire.dao;

import ua.com.codefire.dao.entity.Place;

import java.util.List;

public interface IPlacesDAO {
    List<Place> getAll();

    Place getById(int id);

    void add(Place place);

    Place getByName(String name);

    int getMaxPlaceId();
}
