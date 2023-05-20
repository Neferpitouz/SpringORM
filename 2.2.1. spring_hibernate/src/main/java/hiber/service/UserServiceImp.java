package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional
   @Override
   public void addCar(User user, Car car) {
      userDao.addCar(user, car);
   }

   @Transactional(readOnly = true)
   @Override
   public List<Car> carsList() {
      return userDao.listCars();
   }

   @Transactional
   @Override
   public User getUserByModelSeries(String carModel, int carSeries) {
      return userDao.getUserByCarModelAndSeries(carModel, carSeries);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

}
