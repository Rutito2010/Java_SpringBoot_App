package com.example.DesafioEntregableSpringboot.Controller;

import com.example.DesafioEntregableSpringboot.Entities.Laptop;
import com.example.DesafioEntregableSpringboot.Repository.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/Laptops")
    public List<Laptop> getLaptops() {
        return laptopRepository.findAll();
    }

    @GetMapping("/api/Laptops/{id}")
            public ResponseEntity<Laptop> getBuId(@PathVariable Long id) {
        Optional<Laptop> result = laptopRepository.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());}
            else{
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping("/api/Laptops")
    public void laptop(@RequestBody Laptop laptop){
        laptopRepository.save(laptop);

    }
    }



