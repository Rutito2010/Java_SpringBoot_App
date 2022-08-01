package com.example.DesafioEntregableSpringboot.Controller;

import com.example.DesafioEntregableSpringboot.Entities.Laptop;
import com.example.DesafioEntregableSpringboot.Repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    @Value("${app.message")
    String message ;
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/Laptops")

    public ResponseEntity<List<Laptop> >getLaptops() {
        List<Laptop> list =laptopRepository.findAll() ;
        if(list.size() != 0) {
            return  ResponseEntity.ok(list);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/Laptops/{id}")
            public ResponseEntity<Laptop> getById(@PathVariable Long id) {
        Optional<Laptop> result = laptopRepository.findById(id);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping("/api/Laptops")
    public ResponseEntity<Laptop> createLaptop(@RequestBody Laptop laptop){
        if(laptop.getId() != null){
            return ResponseEntity.badRequest().build();
        }else{
            Laptop created =laptopRepository.save(laptop);
            return ResponseEntity.ok(created);
        }


    }
        @PutMapping("/api/Laptops")
    public ResponseEntity<Laptop>  updateLaptop (@RequestBody Laptop laptop){
        if(laptop.getId()== null){
            return ResponseEntity.badRequest().build();
        }else{
            if(laptopRepository.existsById(laptop.getId())){
                return ResponseEntity.ok(laptopRepository.save(laptop));
            }else{
                return ResponseEntity.notFound().build();
            }
        }
    }

        @DeleteMapping("/api/Laptops/{id}")
    public ResponseEntity<Void> deleteLaptop(@PathVariable("id") Long id) {
            if (laptopRepository.existsById(id)) {
                laptopRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/api/Laptops")
    public ResponseEntity<Void> deleteAllLaptops() {
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
        }
}



