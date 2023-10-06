package com.test;

import org.domain.Application;
import org.domain.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,classes = Application.class)
@AutoConfigureWebTestClient
public class SpringIntegrationTest {
    @Autowired
    private WebTestClient webTestClient;
    @Test
    public void testForGetMapping(){
        EntityExchangeResult<String> result = webTestClient.get()
                                     .uri("/test")
                                     .exchange()
                                     .expectStatus().isOk()
                                     .expectBody(String.class)
                                     .returnResult();
        System.out.println(result);
    }
    @Test
    public void testForPostMapping(){
        EntityExchangeResult<String> result = webTestClient.post()
                .uri("/test/another")
                .bodyValue("BODYVALUE")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .returnResult();
        System.out.println(result);

    }

}
