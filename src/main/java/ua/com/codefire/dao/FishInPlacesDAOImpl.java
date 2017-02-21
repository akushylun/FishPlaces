
package ua.com.codefire.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.codefire.dao.entity.Fish;
import ua.com.codefire.dao.entity.FishInPlace;
import ua.com.codefire.dao.entity.Place;
import ua.com.codefire.sessionFactory.Sessions;

@Repository
public class FishInPlacesDAOImpl implements IFishInPlaceDAO {

    @Override
    @Transactional
    public void addFishInPlace(Fish fish, Place place) {
        Session session = Sessions.getCurrentSession();
        FishInPlace fishinplace = new FishInPlace(fish, place);
        session.save(fishinplace);
        session.close();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Fish> getFishInPlace(Place place) {
        Query query = Sessions.getCurrentSession().
                getNamedQuery("FishInPlaces.findByPlaceId").setParameter("placeId", place);
		List<Fish> listFish = query.list();
        return listFish;
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Place> getPlacesWithFish(Fish fish) {
        Query query = Sessions.getCurrentSession().
                getNamedQuery("FishInPlaces.findByFishId").setParameter("fishId", fish);
        List<Place> listPlaces = query.list();
        return listPlaces;
    }

}
