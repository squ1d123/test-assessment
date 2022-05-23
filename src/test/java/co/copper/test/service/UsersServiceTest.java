package co.copper.test.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import co.copper.test.dto.RandomUserResult;
import co.copper.test.services.UsersService;
import co.copper.test.storage.UsersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

@ExtendWith(MockitoExtension.class)
public class UsersServiceTest {

    @InjectMocks
    private UsersService usersService;

    @Mock
    private UsersRepository usersRepository;

    private final WebClient webClient = WebClient.create();

    @Test
    void testGetRandomUsers() {
        RandomUserResult randomUserResult  = usersService.getRandomUsers()
            .block();

        assertThat(randomUserResult, is(notNullValue()));
        System.out.println(randomUserResult);
        assertThat(randomUserResult.getResults(), is(notNullValue()));
    }

}
