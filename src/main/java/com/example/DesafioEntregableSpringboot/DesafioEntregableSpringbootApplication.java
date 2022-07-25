package com.example.DesafioEntregableSpringboot;



import com.example.DesafioEntregableSpringboot.Controller.HelloController;
import com.example.DesafioEntregableSpringboot.Entities.Laptop;
import com.example.DesafioEntregableSpringboot.Repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DesafioEntregableSpringbootApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(DesafioEntregableSpringbootApplication.class, args);

		HelloController repository = context.getBean(HelloController.class);
		LaptopRepository laptopsList= context.getBean(LaptopRepository.class);

		Laptop Laptop1= new Laptop(null,"G250","Exo",140,"1 terabyte");
		Laptop Laptop2= new Laptop(null,"X300","Asus",300,"2 terabyte");

		laptopsList.save(Laptop1);
		laptopsList.save(Laptop2);
		System.out.println("Programa Corriendo!");

	}

}
