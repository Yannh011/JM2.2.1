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

      User yan = new User("Yan", "Idiyatov", "123@asf");
      Car car = new Car("BMW", 7);
      yan.setCar(car);
      userService.add(yan);

      User jhon = new User("Jhon","Weak","321@cq");
      Car car1 = new Car("Audi", 5);
      jhon.setCar(car1);
      userService.add(jhon);

      User tom = new User("Tom","Breadly","32111@cfq");
      Car car2 = new Car("Mers", 10);
      tom.setCar(car2);
      userService.add(tom);

      User bred = new User("Bred","Pit","111@cfq");
      Car car3 = new Car("Volvo", 3);
      bred.setCar(car3);
      userService.add(bred);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user.toString());
      }

      System.out.println(userService.userGetCar("Volvo", 3));

      context.close();
   }
}
