
package ua.com.codefire.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.codefire.dao.IPlacesDAO;
import ua.com.codefire.dao.entity.Place;

@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {
    
    @Autowired
    private IPlacesDAO placesDAO;

    @Transactional(readOnly = true)
    @Override
    public Place findPlaceById(int id) {
        return placesDAO.getById(id);
    }

    @Override
    public int getMaxPlaceId() {
        return placesDAO.getMaxPlaceId();
    }
}
