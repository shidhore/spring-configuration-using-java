import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ms.springannotationconfigusingxml.service.AdminService;
import com.ms.springannotationconfigusingxml.service.GuestService;
import com.ms.springannotationconfigusingxml.service.UserService;
import com.ms.springannotationconfigusingxml.service.UserServiceImpl;

public class SpringConfigurationUsingJavaDemo {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("");

		// JavaConfig on setter
		System.out.println("==== JavaConfig on setter ====");
		// looping to verify the hashcodes are same which means it's the cached spring
		// bean instance and not a new instance for every invocation.
		for (int i = 0; i < 3; i++) {
			UserService userService = appContext.getBean("userService", UserService.class);
			System.out.println("Now retrieving first user...");
			System.out.println("user name = " + userService.getUsers().get(0).getUserName());
			System.out.println("hashcode of UserServiceImpl object = " + userService.hashCode());
			System.out.println("hashcode of UserRepositoryImpl object = "
					+ ((UserServiceImpl) userService).getUserRepository().hashCode());
			System.out.println("");
		}

		// JavaConfig on constructor
		System.out.println("==== JavaConfig on constructor ====");
		AdminService adminService = appContext.getBean("adminServiceNameMustMatch", AdminService.class);
		System.out.println("Now retrieving first admin...");
		System.out.println("admin name = " + adminService.getAdmins().get(0).getUserName());
		System.out.println("admin role = " + adminService.getAdmins().get(0).getRole());
		System.out.println("");

		appContext = new AnnotationConfigApplicationContext(AppConfigFullyAutowired.class);

		// Fully Autowired using constructor and setter
		// note that the first argument inside getBean(...) method (guestServ in this
		// case) must match bean name in @Service annotation.
		System.out.println("");
		System.out.println("==== Truly Autowired using constructor and setter ====");
		GuestService guestServBean = appContext.getBean("guestServ", GuestService.class);
		System.out.println("Now retrieving first guest...");
		System.out.println("guest name = " + guestServBean.getGuests().get(0).getUserName());
		System.out.println("Now retrieving first guest pass...");
		System.out.println("guest pass number = " + guestServBean.getGuestPasses().get(0).getPassNumber());
		System.out.println("");
		GuestService anotherGuestServ = appContext.getBean("anotherGuestServ", GuestService.class);
		System.out.println("Now retrieving first guest...");
		System.out.println("guest name = " + anotherGuestServ.getGuests().get(0).getUserName());
		System.out.println("Now retrieving first guest pass...");
		System.out.println("guest pass number = " + anotherGuestServ.getGuestPasses().get(0).getPassNumber());
		System.out.println("");
		
		// if you debug the code above, you'll notice that GuessPassRepository and GuestRepository objects 
		// inside guestServ bean and anotherGuestServ are same, i.e. they have identical hashcodes. It shows
		// that Spring has created singleton instances of those beans because no explicit scope is mentioned.
	}

}
