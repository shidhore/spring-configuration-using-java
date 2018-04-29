import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import com.ms.springannotationconfigusingxml.repository.AdminRepository;
import com.ms.springannotationconfigusingxml.repository.AdminRepositoryImpl;
import com.ms.springannotationconfigusingxml.repository.UserRepository;
import com.ms.springannotationconfigusingxml.repository.UserRepositoryImpl;
import com.ms.springannotationconfigusingxml.service.AdminService;
import com.ms.springannotationconfigusingxml.service.AdminServiceImpl;
import com.ms.springannotationconfigusingxml.service.UserService;
import com.ms.springannotationconfigusingxml.service.UserServiceImpl;

@Configuration
@PropertySource("app.properties") // to read properties file - you either need this or the getPropertySourcesPlaceholderConfigurer(...) method defined below, but not both.
public class AppConfig {

	// Bean name must match first argument value in 'appContext.getBean(...);' method invocation.
	@Bean(name = "userService")
	public UserService getUserService() {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		userServiceImpl.setUserRepository(getUserRepository());
		return userServiceImpl;
	}

	@Bean(name = "userRepository")
	public UserRepository getUserRepository() {
		return new UserRepositoryImpl();
	}

	@Bean(name = "adminServiceNameMustMatch")
	public AdminService getAdminService() {
		AdminService adminServiceImpl = new AdminServiceImpl(getAdminRepository());
		return adminServiceImpl;
	}

	@Bean(name = "adminRepository")
	public AdminRepository getAdminRepository() {
		return new AdminRepositoryImpl();
	}

	/*@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
		pspc.setLocation(new ClassPathResource("app.properties"));
		return pspc;
	}*/

}
