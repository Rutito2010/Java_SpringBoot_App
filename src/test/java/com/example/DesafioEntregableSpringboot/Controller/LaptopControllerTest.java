package com.example.DesafioEntregableSpringboot.Controller;

import com.example.DesafioEntregableSpringboot.Entities.Laptop;
import com.example.DesafioEntregableSpringboot.Repository.LaptopRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LaptopControllerTest {

    @Autowired
    private LaptopRepository laptopRepository;

    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder=restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate=new TestRestTemplate(restTemplateBuilder);
    }
    @Test
    @Order(1)
    public void saveLaptop(){
        Laptop laptop = Laptop.builder()
                .modelo("Asus 300")
                .marca("Asus").precio(1100)
                .espacio("2 terabyte")
                .build();
    laptopRepository.save(laptop);

    Assertions.assertThat(laptop.getId()).isGreaterThan(0);
    }



   /* @Test
    @Order(3)
    void getLaptops() {
        ResponseEntity<Laptop[]> response=
        testRestTemplate.getForEntity("/api/Laptops", Laptop[].class);
        if(response.getBody()==null) {
            assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        }else{
            List<Laptop> result= Arrays.asList(response.getBody());
             assertEquals(HttpStatus.OK, response.getStatusCode());
        }

    }*/


    //@Test
    //@Order(2)
   // void getById() {
      //  ResponseEntity<Laptop> response=
        //testRestTemplate.getForEntity("/api/Laptops/1", Laptop.class );

        //if(response.getBody()==null) {
        //assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());}
        //else{
          //  assertEquals(HttpStatus.OK, response.getStatusCode());
        //}
    //}


   /* @Test
    @Order(4)
    void createLaptop() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        String json = """
        {
        "id":null,
        "modelo": "asus 2500G",
        "marca": "asus",
        "precio": 1100,
        "espacio":"2 terabyte"
        }
        """;*/


      /*  HttpEntity<String> request=  new HttpEntity<>(json, headers);
             ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/Laptops",HttpMethod.POST,request,Laptop.class);
                 Laptop result= response.getBody();
           assertEquals(2L,result.getId());
           assertEquals("asus 2500G", result.getModelo());
    }*/


}