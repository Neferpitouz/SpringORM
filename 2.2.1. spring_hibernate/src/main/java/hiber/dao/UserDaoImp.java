package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().saveOrUpdate(user);
      Car car = user.getCar();
      if (car != null) {
         sessionFactory.getCurrentSession().saveOrUpdate(car);
      }
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query= (TypedQuery<User>) sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public List<Car> listCars() {
      TypedQuery<Car> query= (TypedQuery<Car>) sessionFactory.getCurrentSession().createQuery("from Car");
      return query.getResultList();
   }
   @Override
   public User getUserByCarModelAndSeries(String carModel, int carSeries) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
              "select u from User u join u.car c where c.model = :model and c.series = :series");
      query.setParameter("model", carModel);
      query.setParameter("series", carSeries);
      return query.getSingleResult();
   }

}
