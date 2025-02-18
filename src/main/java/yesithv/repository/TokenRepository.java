package yesithv.repository;

import org.springframework.data.repository.CrudRepository;
import yesithv.model.Token;

public interface TokenRepository extends CrudRepository<Token, Long> {
}
