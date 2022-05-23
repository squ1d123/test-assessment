package co.copper.test.dto;

import java.util.List;
import lombok.Data;

@Data
public class RandomUserResult {
    // This field name was previously userDetails, which caused the error as spring could not match the field to the expected name
    private List<UserDetails> results;
}
