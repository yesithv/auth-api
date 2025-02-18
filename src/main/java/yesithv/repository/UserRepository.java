package yesithv.repository;

import org.springframework.data.repository.CrudRepository;
import yesithv.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
