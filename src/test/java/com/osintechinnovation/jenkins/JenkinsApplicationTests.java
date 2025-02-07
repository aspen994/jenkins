package com.osintechinnovation.jenkins;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JenkinsApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	TestRestTemplate template;

	@Test
	void sayHelloJenkinsTest() throws Exception {

		assertThat(template.getForObject("http://localhost:"+port+"/", String.class)).contains("Hello Jenkins");

	}

}
