
package ua.com.codefire.services;

import ua.com.codefire.dao.entity.Place;

public interface PlaceService {

	Place findPlaceById(int id);

	int getMaxPlaceId();
}
