package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      userService.addCar(new User("Test1","Test1_1", "test@gmail.com"),
              new Car("Testla", 771));
      userService.addCar(new User("Test2","Test2_1", "test2@gmail.com"),
              new Car("Testla2", 772));
      userService.addCar(new User("Test3","Test3_1", "test3@gmail.com"),
              new Car("Testla3", 773));
      List<Car> cars = userService.carsList();
      for (Car car : cars) {
         System.out.println(car);
      }

      System.out.println(userService.getUserByModelSeries("Testla", 771));

      context.close();
   }
}
