package hiber.dao;

import hiber.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

   Optional<User> getUserByCar(int id, String model);
}
