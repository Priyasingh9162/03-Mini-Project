package priya.in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import priya.in.repo.InsurancePlanDetailsRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		InsurancePlanDetailsRepo bean = run.getBean(InsurancePlanDetailsRepo.class);
		
	}

}
