package eTicaret.core;

import eTicaret.entities.concretes.User;

public interface AuthService {
	void register(User user);
	void login(User user);
}
