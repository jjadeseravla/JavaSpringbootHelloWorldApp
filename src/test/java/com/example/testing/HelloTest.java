package com.example.testing;

import com.example.testing.domain.Hello;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class HelloTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getLine_returnsHelloWorld() throws Exception {
		//arrange

		//act
		ResponseEntity<Hello> response = restTemplate
				.getForEntity("/hello", Hello.class);

		//assert
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody().getLine()).isEqualTo("Hello World");
	}

}
