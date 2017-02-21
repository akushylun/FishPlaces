
package ua.com.codefire.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.codefire.dao.entity.Place;
import ua.com.codefire.sessionFactory.Sessions;

@Repository
public class PlacesDAOImpl implements IPlacesDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Place> getAll() {
		Session session = Sessions.getCurrentSession();
		List<Place> place = ((List<Place>) session.createCriteria(Place.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list());
		session.close();
		return place;
	}

	@Override
	public void add(Place place) {
		Session session = Sessions.getCurrentSession();
		session.save(place);
		session.close();
	}

	@Transactional
	@Override
	public Place getById(int id) {
		Session session = Sessions.getCurrentSession();
		Query query = session.getNamedQuery("Places.findByPlaceId").setInteger("placeId", id);
		session.close();
		return (Place) query.uniqueResult();
	}

	@Override
	public Place getByName(String name) {
		Session session = Sessions.getCurrentSession();
		Query query = Sessions.getCurrentSession().getNamedQuery("Places.findByPlaceName").setString("placeName", name);
		session.close();
		return (Place) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getMaxPlaceId() {
		Session session = Sessions.getCurrentSession();
		List<Place> list = session.createSQLQuery("SELECT * FROM fishmap.places ORDER BY place_id DESC LIMIT 1")
				.addEntity(Place.class).list();
		Place place = list.get(0);
		session.close();
		return place.getPlaceId();
	}
}
