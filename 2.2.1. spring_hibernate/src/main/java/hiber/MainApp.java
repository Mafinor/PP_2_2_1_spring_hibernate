package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      List<Integer> list = new ArrayList<>();

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("test1")));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("test2")));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("test3")));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("test4")));

      List<User> users = userService.listUsers();
      for (User user : users) {
         printUser(user);
      }
      User user = userService.getUserByCar(1, "test2342");
      if (user != null) {
         printUser(user);
      }
      context.close();
   }

   private static void printUser(User user) {
      System.out.println("Id = "+ user.getId());
      System.out.println("First Name = "+ user.getFirstName());
      System.out.println("Last Name = "+ user.getLastName());
      System.out.println("Email = "+ user.getEmail());
      System.out.println("Car = "+ user.getCar().getSeries() + " " + user.getCar().getModel());
      System.out.println();
   }
}
