package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void add(User user);

    @Transactional(readOnly = true)
    List<Car> carsList();

    @Transactional
    User getUserByModelSeries(String carModel, int carSeries);

    List<User> listUsers();


}
