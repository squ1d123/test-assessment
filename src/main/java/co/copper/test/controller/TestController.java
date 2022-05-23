package co.copper.test.controller;

import co.copper.test.services.TestJavaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController()
@RequestMapping("/tests")
public class TestController {
    private final TestJavaService testJavaService;

    @GetMapping("/postman-get")
    public ResponseEntity<Mono<String>> getPostman() {
        return ResponseEntity.ok(testJavaService.postmanGet());
    }

}
