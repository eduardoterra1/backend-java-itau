package desafio.itau.springboot;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import desafio.itau.springboot.model.Transaction;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SpringbootApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTransacaoSucess() {
	var transaction = new Transaction(123.45, OffsetDateTime.parse("2025-05-07T14:30:00.000Z"));
	webTestClient
		.post()
		.uri("/transacao")
		.bodyValue(transaction)
		.exchange()
		.expectStatus().isCreated()
		.expectBody().isEmpty();		
	}

	@Test
	void testCreateTransacaoFailure() {
	webTestClient
		.post()
		.uri("/transacao")
		.bodyValue(
			new Transaction(-123.45, OffsetDateTime.parse("2029-05-07T14:30:00.000Z")))
		.exchange()
		.expectStatus().is4xxClientError();
	}

}
