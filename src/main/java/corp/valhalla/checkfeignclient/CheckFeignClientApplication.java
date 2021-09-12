package corp.valhalla.checkfeignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import corp.valhalla.checkfeignclient.model.Category;
import corp.valhalla.checkfeignclient.repository.CategoryRepository;

@SpringBootApplication
@EnableFeignClients
public class CheckFeignClientApplication {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CheckFeignClientApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			Category tmp = this.categoryRepository.getCategoryById("eb43f908-2007-4f1c-9e62-0d49560886be") ;
			System.out.println( tmp.getId() );
			System.out.println( tmp.getName() );
			System.out.println( tmp.getCompanyKey() );

		};
	}

}
