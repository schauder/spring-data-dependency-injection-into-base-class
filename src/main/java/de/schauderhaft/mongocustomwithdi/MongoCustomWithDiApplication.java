package de.schauderhaft.mongocustomwithdi;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(
		repositoryBaseClass = MyBaseClass.class,
		repositoryFactoryBeanClass = MyRepositoryFactoryBean.class)
public class MongoCustomWithDiApplication {

	private final ThingyRepository repository;

	public MongoCustomWithDiApplication(ThingyRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MongoCustomWithDiApplication.class, args);
	}

	@PostConstruct
	public void run() {
		System.out.println("running");

		repository.doSomethingCustom();

		System.out.println("done");
	}
}
