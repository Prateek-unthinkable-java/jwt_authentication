package developer.prateek.jwt_authentication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long userId;
    private String username;
    private String password;
    private String userEmail;
}
