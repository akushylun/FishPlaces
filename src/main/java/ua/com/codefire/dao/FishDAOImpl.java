
package ua.com.codefire.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.codefire.dao.entity.Fish;
import ua.com.codefire.sessionFactory.Sessions;

@Repository
public class FishDAOImpl implements IFishDAO {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Fish> getAll() {
		Session session = Sessions.getCurrentSession();
		List<Fish> listFish = ((List<Fish>) session.createCriteria(Fish.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list());
		session.close();
		return listFish;
	}

	@Override
	@Transactional
	public void addFish(Fish fish) {
		Session session = Sessions.getCurrentSession();
		session.save(fish);
		session.close();
	}

	@Override
	public Fish getByName(String name) {
		Session session = Sessions.getCurrentSession();
		Fish fish = null;
		Query query = session.getNamedQuery("Fishes.findByFishName").setString("fishName", name);
		fish = (Fish) query.uniqueResult();
		Sessions.closeCurrentSession();
		return fish;
	}

}
