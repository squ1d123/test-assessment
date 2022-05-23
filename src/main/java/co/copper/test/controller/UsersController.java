package co.copper.test.controller;

import co.copper.test.datamodel.Users;
import co.copper.test.services.UsersService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController()
@RequestMapping("/users")
public class UsersController {

    private final UsersService service;
    @GetMapping()
    public ResponseEntity<Mono<List<Users>>> getUsers() {

        return ResponseEntity.ok(Mono.just(service.getAll()));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/create")
    public ResponseEntity<Mono<List<Users>>> postUsers() {
        return ResponseEntity.ok(service.createRandomUsers());
    }

}
