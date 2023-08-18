package com.nutrition.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;
import com.nutrition.model.NutritionModel;

@Repository
public class NutritionRepo {
	NutritionModel nutritionModel;
	NutritionModel fooddao;

	private Session getHibernateSession() {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(NutritionModel.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		return sf.openSession();
	}

	public NutritionModel createFoodDetails(NutritionModel nutritionModel) {
		Session session = getHibernateSession();
		Transaction tx = (Transaction) session.beginTransaction();
		session.save(nutritionModel);
		// fooddao = session.get(NutritionModel.class, nutritionModel.getFoodname());
		// System.out.println(fooddao);
		tx.commit();
		return fooddao;
	}

	public NutritionModel getSearchFood(String foodname) {
		Session session = getHibernateSession();
		Transaction tx = (Transaction) session.beginTransaction();
		Criteria query = session.createCriteria(NutritionModel.class);
		query.add(Restrictions.like("foodname", foodname, MatchMode.ANYWHERE));
	    List<NutritionModel> list = query.list();	    
		tx.commit();
		NutritionModel nutritionmodel = list.get(0);
		return nutritionmodel;
	}

	public List<NutritionModel> getFoodList(String foodname) {
		List<NutritionModel> list;
		Session session = getHibernateSession();
		Criteria query = session.createCriteria(NutritionModel.class);
		query.add(Restrictions.like("foodname", foodname, MatchMode.ANYWHERE));
		list = query.list();
		return list;
	}
}
