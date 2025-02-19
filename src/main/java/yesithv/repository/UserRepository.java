package yesithv.repository;

import org.springframework.data.repository.CrudRepository;
import yesithv.model.User;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
}
