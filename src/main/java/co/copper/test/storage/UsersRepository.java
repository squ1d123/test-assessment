package co.copper.test.storage;

import co.copper.test.datamodel.Users;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, UUID> {

}
