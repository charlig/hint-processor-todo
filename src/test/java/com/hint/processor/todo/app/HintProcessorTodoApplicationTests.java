package com.hint.processor.todo.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HintProcessorTodoApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;


	@Test
	void todoHtmlList() {
		ResponseEntity<String> result = restTemplate.exchange(RequestEntity.get("/list").build(), String.class);
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		System.out.println(result.getBody());
		assertThat(result.getBody()).contains("David", "Mark", "Clark", "Peter");
	}

	@Test
	void htmlBanner() throws IOException {
		ClassPathResource resource = new ClassPathResource("todo-banner.txt");
		String banner = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

		ResponseEntity<String> result = restTemplate.exchange(RequestEntity.get("/banner").build(), String.class);
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(result.getBody()).contains(banner);
	}

}
