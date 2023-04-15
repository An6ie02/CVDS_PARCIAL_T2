package edu.eci.cvds.springboot;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.eci.cvds.springboot.Model.Employee;
import edu.eci.cvds.springboot.Service.EmployeeService;

// Clase de entrada
@SpringBootApplication
public class Application {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return (args) -> {
			
			System.out.println("\nDeleting employees....");
			employeeService.deleteEmployees();

			System.out.println("Adding employee....\n");
			employeeService.addEmployee(new Employee("Angie", "Mojica", LocalDate.of(2002,05,15), "Gerente", 1.200));
			employeeService.addEmployee(new Employee("Jorge", "Useche", LocalDate.of(1995,01,15), "Gerente", 3.200));

			System.out.println("\nGetting all employees....");
			employeeService.getAllEmployees().forEach(employee -> System.out.println(employee));
			
		};
	}

}
