package com.Tarea3.Ejercicios1_2_3.controller;

import com.Tarea3.Ejercicios1_2_3.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;


    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);


    }

    @Test
    void findAll() {
        ResponseEntity<String> response  =
                testRestTemplate.getForEntity("/", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Hola, desde Hello Controller", response.getBody());
    }

    @Test
    void findOneById() {
        ResponseEntity<Laptop> response  =
                testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "ramGB": 32,
                    "storageGB": 2048,
                    "cpu": "Intel i7",
                    "screen": "1366x768",
                    "systemOperative": "Ubuntu"
                    }
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops/", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();

        assertEquals("Ubuntu", result.getSystemOperative());
    }

}