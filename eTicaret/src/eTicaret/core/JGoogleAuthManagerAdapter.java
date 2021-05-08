package eTicaret.core;

import eTicaret.JAuth.JGoogleAuthManager;
import eTicaret.entities.concretes.User;

public class JGoogleAuthManagerAdapter implements AuthService {

	@Override
	public void register(User user) {
		JGoogleAuthManager jGoogleAuthManager = new JGoogleAuthManager();
		jGoogleAuthManager.register(user);
		
	}

	@Override
	public void login(User user) {
		JGoogleAuthManager jGoogleAuthManager = new JGoogleAuthManager();
		jGoogleAuthManager.login(user);
		
	}

}
