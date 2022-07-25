package com.example.DesafioEntregableSpringboot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String Saludo(){
      return "Bienvenido a mi Ejercicio Java Spring Boot";
    };

}
