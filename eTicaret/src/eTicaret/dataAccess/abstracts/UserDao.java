package eTicaret.dataAccess.abstracts;

import java.util.List;

import eTicaret.entities.concretes.User;

public interface UserDao {
 void add(User user);
 void delete(User user);
 void update(User user);
 User get(int id);
 List<User> getall();

}
