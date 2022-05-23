package co.copper.test.datamodel;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Data
public class Users {

    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String password;
}
