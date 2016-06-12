package com.narae;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SeoulTravelApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
public class SeoulTravelApplicationTests {


	private RestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void sample() {
		ResponseEntity<Sample> entity =
				restTemplate.getForEntity("http://localhost:9000/sample", Sample.class);

		assertThat(entity.getStatusCode().is2xxSuccessful(), is(true));
		assertThat(entity.getBody().getText(), equalTo("sample"));
	}

}
