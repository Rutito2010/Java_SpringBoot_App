package com.example.DesafioEntregableSpringboot.Controller;

import com.example.DesafioEntregableSpringboot.Repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${app.message}")
    String message ;

    @GetMapping("/")

    public String Saludo(){
        System.out.println(message);
        return "Bienvenido a mi Ejercicio Java Spring Boot";
    };

}
