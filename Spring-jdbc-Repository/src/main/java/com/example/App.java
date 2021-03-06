package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {
		
		// 추가
		Customer created = customerRepository.save(new Customer(
				null, "Hidetoshi","Dekisugi"));
		System.out.println(created + " is created!");
		// 조회
		customerRepository.findAll().forEach(System.out::println);// (x)-> {System.out.println(x);} 간략화
	}
	

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
