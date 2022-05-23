package co.copper.test.services;

import co.copper.test.datamodel.Test;
import co.copper.test.storage.TestJavaRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class TestJavaService {

    private static final Logger log = LoggerFactory.getLogger(TestJavaService.class);
    private final TestJavaRepository testRepo;
    private final WebClient webClient = WebClient.create();

    public List<Test> getAll() {
        return testRepo.findAll();
    }

    public Mono<String> postmanGet() {
        return webClient.get().uri("https://postman-echo.com/get").retrieve()
            .bodyToMono(String.class);
    }
}
