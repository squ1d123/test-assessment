package co.copper.test.services;

import co.copper.test.datamodel.Users;
import co.copper.test.dto.RandomUserResult;
import co.copper.test.storage.UsersRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class UsersService {

    private static final Logger log = LoggerFactory.getLogger(UsersService.class);
    private final UsersRepository usersRepository;
    private final WebClient webClient = WebClient.create();

    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    public Mono<RandomUserResult> getRandomUsers() {
        return webClient.get().uri("https://randomuser.me/api/?results=20").retrieve()
            .bodyToMono(RandomUserResult.class);
    }

    public Mono<String> foo() {
        return webClient.get().uri("https://randomuser.me/api/?results=20").retrieve()
            .bodyToMono(String.class);
    }
    
    public Mono<List<Users>> createRandomUsers() {
       return getRandomUsers()
            .map(RandomUserResult::getResults)
            .map(userDetails -> userDetails.stream()
                .map(userD -> Users.builder()
                    .id(UUID.randomUUID())
                    .firstName(userD.getName().getFirst())
                    .lastName(userD.getName().getLast())
                    .gender(userD.getGender())
                    .email(userD.getEmail())
                    .password(userD.getLogin().getPassword())
                    .build())
                .collect(Collectors.toList()))
            .map(usersRepository::saveAll);
    }


}
