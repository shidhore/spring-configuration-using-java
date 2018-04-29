import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration // this is likely not needed as commenting this out doesn't seem to make any difference - it may be covered by @ComponentScan
@ComponentScan(basePackages = "com.ms.springannotationconfigusingxml")
@PropertySource("app.properties") // to read properties file - you either need this or the getPropertySourcesPlaceholderConfigurer(...) method defined below, but not both.
public class AppConfigFullyAutowired {
	
	// read the notenote that @Bean definition for PropertySourcesPlaceholderConfigurer like in AppConfig.java is not required - 
	
	/*@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
		pspc.setLocation(new ClassPathResource("app.properties"));
		return pspc;
	}*/

}
