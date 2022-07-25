package com.example.DesafioEntregableSpringboot.Repository;

import com.example.DesafioEntregableSpringboot.Entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LaptopRepository extends JpaRepository<Laptop ,Long> {
}
