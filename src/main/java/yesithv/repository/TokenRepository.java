package yesithv.repository;

import org.springframework.data.repository.CrudRepository;
import yesithv.model.Token;

import java.util.List;
import java.util.UUID;

public interface TokenRepository extends CrudRepository<Token, UUID> {
    List<Token> findAllValidIsFalseOrRevokedIsFalseByUserId(UUID id);
}
