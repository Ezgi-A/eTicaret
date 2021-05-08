package eTicaret.business.concretes;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eTicaret.business.abstracts.UserService;
import eTicaret.core.AuthService;
import eTicaret.dataAccess.abstracts.UserDao;
import eTicaret.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private AuthService authService;
	

	public UserManager(UserDao userDao, AuthService authService) {
		super();
		this.userDao = userDao;
		this.authService=authService;
	}

	@Override
	public void add(User user) {
		if (register(user)==false) {
			System.out.println("Hata! Eklenmedi");
			
		}
		userDao.add(user);
		
	}

	@Override
	public boolean register(User user) {
		if (user.getPassword().length()<6 || user.getFirstName().length()<2 || user.getLastName().length()<2 || emailValidator(user.getEmail())==false) {
			System.out.println("Kayýt oluþturulamadý, bilgilerinizi kontrol ediniz!");
			return false;
			
		}
		
		authService.register(user);
		
		return true;
	}

	@Override
	public boolean login(User user) {
		if (user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
			return false;
		}
		
		authService.login(user);
		return true;
		
		
	}

	@Override
	public boolean emailValidator(String email) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
	   if (matcher.matches()==false) {
		   System.out.println("Email doðrulamasý baþarýsýz!");
		
	}
	
		return true;
	}

	@Override
	public boolean emailVerification(User user) {
		System.out.println("Onaylama baþarýlý. Siteye yönlendiriliyorsunuz!");
		return true;
	}

}
