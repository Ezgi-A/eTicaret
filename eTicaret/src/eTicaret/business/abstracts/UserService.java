package eTicaret.business.abstracts;

import eTicaret.entities.concretes.User;

public interface UserService {
	void add(User user);
	boolean emailValidator(String email);
	boolean emailVerification(User user);
	boolean register(User user);
	boolean login(User user);

}
