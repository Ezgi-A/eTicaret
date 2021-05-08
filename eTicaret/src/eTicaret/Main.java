package eTicaret;

import eTicaret.business.abstracts.UserService;
import eTicaret.business.concretes.UserManager;
import eTicaret.core.JGoogleAuthManagerAdapter;
import eTicaret.dataAccess.concretes.HibernateUserDao;
import eTicaret.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1=new User(1,"Ezgi","Arslan","ezgi@gmail.com","123456");
		registerSimulation(user1);
		loginSimulation(user1);
		
		
		
		
		

	}
	private static void registerSimulation(User user) {
		UserService userService=new UserManager(new HibernateUserDao(),new JGoogleAuthManagerAdapter());
	
		if (userService.register(user)==true) {
			System.out.println("Emailinize onaylama postasý gönderilmiþtir!");
			
			
			if (userService.emailVerification(user)==true) {
				System.out.println("Kayýt OLuþturuldu!");
			}
			else {
				System.out.println("Kayýt Oluþturulamadý:( ");
			}
		}
		
		
		
	}


private static void loginSimulation(User user) {
	UserService userService = new UserManager(new HibernateUserDao(),new JGoogleAuthManagerAdapter());
	
	
	if (userService.login(user)) {
		System.out.println("Giriþ baþarýlý!");
	}
	else {
		System.out.println("Giriþ baþarýsýz!");
	}
	
	
}
}
